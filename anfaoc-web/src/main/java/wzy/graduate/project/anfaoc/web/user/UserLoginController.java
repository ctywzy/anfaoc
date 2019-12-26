package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.common.exception.RestException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.ZhenziSMS;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@RestController
@Api(tags = "用户登陆管理")
@RequestMapping("/api/anfaoc/user")
@Slf4j
public class UserLoginController {

    @Reference
    private UserDetailFacade userDetailFacade;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Boolean register(@RequestBody UserDetail userDetail){
        //前端js校验
        Response<Boolean> response = userDetailFacade.register(userDetail);
        return response.getResult();
    }

    @ApiOperation("管理员-查看所有用户信息")
    @GetMapping(value = "/getAllUser")
    public List<UserDetail> getAllUser(){
        Response<List<UserDetail>> response = userDetailFacade.getAllUserDetail();
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
    @GetMapping(value = "/userLogin")
    public Boolean userLoginMsg(@RequestParam String phoneNumber
            ,@RequestParam String verityCode){
        //查询该手机号用户是否存在
        /**Boolean result = userDetailFacade.

        if(verityCode.equals()){
            return Boolean.TRUE;
        }else{
            return false;
        }**/
        return Boolean.TRUE;
    }

    @ApiOperation("管理员-获取剩余可用短信额度")
    @GetMapping(value = "remainingSMSCredit")
    public String remainingSMSCredit()  {
        ZhenziSmsClient client = new ZhenziSmsClient(ZhenziSMS.APIURL,ZhenziSMS.APPID,ZhenziSMS.APPSECRET);
        String remaining = new String();
        try{
            remaining = client.balance();
        }catch (Exception e){
            throw  new RestException(e.getMessage());
        }
        log.info("=======》剩余短信条数信息:{}",remaining);
        return remaining;
    }

    @ApiOperation("用户登录校验-邮箱或手机号+密码")
    @GetMapping(value = "/userLogin/phoneOrEmail")
    public Boolean userLoginPhoneOrEmail(){
        return Boolean.TRUE;
    }

}
