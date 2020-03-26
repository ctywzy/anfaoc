package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.exception.RestException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.ZhenziSMS;
import wzy.graduate.project.anfaoc.common.util.RedisUtil;
import wzy.graduate.project.anfaoc.web.cache.RedisKeyConstant;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisHelper redis;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Boolean register(@RequestBody UserDetailDTO userDetailDTO){
        //前端js校验
        Response<Boolean> response = userDetailFacade.register(userDetailDTO);
        return response.getResult();
    }

    @ApiOperation("请求发送验证码")
    @GetMapping("/getVerifyCode")
    public Response<Boolean> getVerifyCode(@RequestParam String phoneNumber) {
        try{
            Integer verityCode = new Random().nextInt(899999) + 100000;
            RedisUtil.getSendVerityCode(phoneNumber,verityCode);
            String verityKey = RedisKeyConstant.getUserLoginVerityCode(phoneNumber);
            redis.valuePut(verityKey,verityCode.toString());
            redis.expirse(verityKey,60,TimeUnit.SECONDS);
        }catch (Exception e){
            return Response.fail("验证码发送出错");
        }
        return Response.ok(Boolean.TRUE);
    }

    @ApiOperation("用户登陆校验-短信验证码方式")
    @GetMapping(value = "/userLogin/verityCode")
    public Response<Boolean> userLoginMsg(@RequestParam String phoneNumber
            ,@RequestParam String verityCode){
            //查询该手机号用户是否存在
            Response<Boolean> response = userDetailFacade.findUserByPhoneNumber(phoneNumber);

            //根据sessionId从缓存中获取手机校验码
            if(Objects.isNull(response.getResult())){
                return Response.fail("用户不存在");
            }
            String verityKey = RedisKeyConstant.getUserLoginVerityCode(phoneNumber);
            String sentVerityCode = (String) redis.getValue(verityKey);
        if(verityCode.equals(sentVerityCode)){
            // 登陆成功删除验证码
            redis.remove(verityKey);
            return Response.ok(Boolean.TRUE);
        }else{
            return Response.fail("验证码错误");
        }
    }

    @ApiOperation("用户登陆校验-密码和名称方式")
    @PostMapping(value = "/userLogin/password")
    public Response<Boolean> userLoginPass(@RequestParam String phoneNumber
            ,@RequestParam String password){

        String errorKey = RedisKeyConstant.getLoginErrorTimes(phoneNumber);

        if(RedisUtil.lockedJudge(redis.getValue(errorKey))){
            return Response.fail("账户已被锁定");
        }

        Response<Boolean> response = userDetailFacade.loginByPhoneNumber(phoneNumber,password);

        if(!response.isSuccess() && ("账号或密码错误").equals(response.getError())){
            int times = RedisUtil.calErrorTimes(redis.getValue(errorKey));
            redis.valuePut(errorKey,times);
            if(times != 0){
                return Response.fail("账号密码错误,再过"+ times +"次将被锁定");
            }else{
                redis.expirse(errorKey,30,TimeUnit.MINUTES);
                return Response.fail("账户已被锁定,请半小时后进行尝试");
            }
        }
        redis.remove(errorKey);
        return response;
    }

}
