package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.PhoneCheckResponse;
import wzy.graduate.project.anfaoc.common.util.PhoneUtil;
import wzy.graduate.project.anfaoc.common.util.RedisUtil;
import wzy.graduate.project.anfaoc.web.cache.RedisKeyConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserDetail")
    public Response<UserDetail> getUserDetail(String userId){
        Response<UserDetail> response = userDetailFacade.findUserByUserId(userId);

        return response;
    }

    @ApiOperation("获取当前用户信息")
    @GetMapping("/getNowUserDetail")
    public Response<UserDetail> getNowUserDetail(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);
        if(Objects.isNull(userId)){
            return Response.fail("未登陆");
        }else{
            return userDetailFacade.findUserByUserId(String.valueOf(userId));
        }

    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Response<Boolean> register(@RequestBody UserDetailDTO userDetailDTO){
        //前端js校验
        if(checkString(userDetailDTO.getPhoneNumber()) || checkString(userDetailDTO.getUserPassword())
                || checkString(userDetailDTO.getCheckPasswrod()) || checkString(userDetailDTO.getUserName())){
            return Response.fail("不允许参数为空");
        }

        if(userDetailDTO.getPhoneNumber().length() != 11){
            return Response.fail("电话号码有误");
        }

        if(!userDetailDTO.getCheckPasswrod().equals(userDetailDTO.getUserPassword())){
            return Response.fail("两次密码输入不一致");

        }
        Response<Boolean> response = userDetailFacade.register(userDetailDTO);
        return response;
    }

    @ApiOperation("请求发送验证码")
    @GetMapping("/getVerifyCode")
    public Response<Boolean> getVerifyCode(@RequestParam String phoneNumber) {
        PhoneCheckResponse response = PhoneUtil.checkPhoneNumber(phoneNumber);
        if(!response.isResult()){
            return Response.fail(response.getMsg());
        }
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
            , @RequestParam String verityCode, HttpServletRequest request){
        //查询该手机号用户是否存在
        Response<UserDetail> response = userDetailFacade.findUserByPhoneNumber(phoneNumber);

        UserDetail userDetail = response.getResult();
        //根据sessionId从缓存中获取手机校验码
        if(Objects.isNull(userDetail)){
            return Response.fail("用户不存在");
        }

        String verityKey = RedisKeyConstant.getUserLoginVerityCode(phoneNumber);
        String sentVerityCode = (String) redis.getValue(verityKey);

        if(verityCode.equals(sentVerityCode)){
            // 登陆成功删除验证码
            redis.remove(verityKey);

            //根据sessionId存储
            String sessionId = request.getRequestedSessionId();
            String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
            redis.valuePut(loginKey,userDetail.getId());
            return Response.ok(Boolean.TRUE);
        }else{
            return Response.fail("验证码错误或已过期");
        }
    }

    @ApiOperation("用户登陆校验-密码和名称方式")
    @PostMapping(value = "/userLogin/password")
    public Response<Boolean> userLoginPass(@RequestParam String phoneNumber
            ,@RequestParam String password,HttpServletRequest request){

        String errorKey = RedisKeyConstant.getLoginErrorTimes(phoneNumber);

        if(RedisUtil.lockedJudge(redis.getValue(errorKey))){
            return Response.fail("账户已被锁定");
        }

        Response<UserDetail> response = userDetailFacade.loginByPhoneNumber(phoneNumber,password);

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

        //根据sessionId存储
        String sessionId = request.getRequestedSessionId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        redis.valuePut(loginKey,response.getResult().getId());
        return Response.ok();
    }

    private boolean checkString(String string){

        if(Objects.isNull(string)){
            return true;
        }
        if(string.length() == 0){
            return true;
        }
        return false;
    }

}
