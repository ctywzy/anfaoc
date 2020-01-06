package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.domain.UserDetail;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.exception.RestException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.ZhenziSMS;
import java.util.Map;
import java.util.Random;

/**
 * @author wangzy
 */
@Api(tags = "用户信息管理--普通用户")
@RequestMapping("/api/anfaoc/user/ordinary")
@RestController
@Slf4j
public class UserController {

    @Reference
    private UserDetailFacade userDetailFacade;

    @Reference
    private RedisHelper redisHelper;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Boolean register(@RequestBody UserDetail userDetail){
        //前端js校验
        Response<Boolean> response = userDetailFacade.register(userDetail);
        return response.getResult();
    }

    @ApiOperation("请求发送验证码")
    @GetMapping("/getVerifyCode")
    public String getVerifyCode(@RequestParam String phoneNumber) {
        ZhenziSmsClient client = new ZhenziSmsClient(ZhenziSMS.APIURL,ZhenziSMS.APPID,ZhenziSMS.APPSECRET);
        Integer verityCode = new Random().nextInt(899999) + 100000;
        StringBuilder message = new StringBuilder("您好，您的验证码是:" + verityCode);
        Map<String,String> params = Maps.newHashMap();
        params.put("number",phoneNumber);
        params.put("message",message.toString());
        String result = new String();
        try{
            result = client.send(params);
        }catch (Exception e){
            throw  new RestException(e.getMessage());
        }
        return result;
    }

    @ApiOperation("用户登陆校验-短信验证码方式")
    @GetMapping(value = "/userLogin/verityCode")
    public Boolean userLoginMsg(@RequestParam String phoneNumber
            ,@RequestParam String verityCode){
        //查询该手机号用户是否存在
        Response<Boolean> response = userDetailFacade.findUserByPhoneNumber(phoneNumber);

        //根据sessionId从缓存中获取手机校验码
        if(verityCode.equals("")){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    @ApiOperation("用户登陆校验-密码和名称方式")
    @PostMapping(value = "/userLogin/password")
    public Response<Boolean> userLoginPass(@RequestParam String phoneNumber,@RequestParam String password){

        Response<Boolean> response = userDetailFacade.loginByPhoneNumber(phoneNumber,password);

        return response;
    }

}
