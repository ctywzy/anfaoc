package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.service.convert.UserDetailConvert;

import java.util.*;

/**
 * @Description 用户详情facade
 * @author wangzy
 * @Date  2019/12/10
 **/

@Slf4j
@Service
public class UserDetailFacadeImpl implements UserDetailFacade {

    @Autowired
    private UserDetailService userDetailService;

    @Override
    public Response<List<UserDetail>> getAllUserDetail() {
        log.info("facade：显示");
        List<UserDetail> userDetailList = null;
        try{
            userDetailList = userDetailService.getAllUserDetail();
        }catch (ServiceException e){
            return Response.fail(e.getMessage());
        }
        return Response.ok(userDetailList);
    }

    @Override
    public Response<Boolean> register(UserDetailDTO userDetailDTO) {
        try{
            UserDetail userDetail = UserDetailConvert.modelConvert(userDetailDTO);
            //判断电话号码是否存在
            UserDetail userJudge = userDetailService.findUserByPhoneNumber(userDetail.getPhoneNumber());
            if(Objects.isNull(userJudge)){
                return Response.fail("电话号码已经被注册");
            }
            userDetailService.register(userDetail);
        }catch (ServiceException e){
            return Response.fail(e.getMessage());
        }
        return Response.ok(Boolean.TRUE);
    }

    @Override
    public Response<UserDetail> findUserByPhoneNumber(String phoneNumber) {
        UserDetail userDetail = null;

        try{
            userDetail = userDetailService.findUserByPhoneNumber(phoneNumber);
        }catch (Exception e){
            return Response.fail(e.getMessage());
        }
        Response<UserDetail> response = Response.ok(userDetail);
        if(Objects.isNull(userDetail)){
            response = Response.fail("用户不存在");
        }
        return response;
    }

    @Override
    public Response<UserDetail> loginByPhoneNumber(String phoneNumber, String password) {

        UserDetail userDetail = null;
        try{
            userDetail = userDetailService.findUserByPhoneNumber(phoneNumber);
        }catch (Exception e){
            return Response.fail(e.getMessage());
        }
        if(Objects.isNull(userDetail)){
            return Response.fail("用户不存在");
        }else{
            if(!password.equals(userDetail.getUserPassword())){
                return  Response.fail("账号或密码错误");
            }
        }
        return Response.ok(userDetail);
    }
}
