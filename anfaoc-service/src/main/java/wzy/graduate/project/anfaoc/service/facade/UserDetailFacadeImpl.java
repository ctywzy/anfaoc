package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.*;

/**
 * @Description //TODO
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
        List<UserDetail> userDetailList = new ArrayList<>();
        try{
            userDetailList = userDetailService.getAllUserDetail();
        }catch (ServiceException e){
            return Response.fail(e.getMessage());
        }
        return Response.ok(userDetailList);
    }

    @Override
    public Response<Boolean> register(UserDetail userDetail) {
        try{
            //HashMap<String,Object> criteria = userDetail.toMap();
            //return Response.ok(userDetailService.register(criteria));
        }catch (ServiceException e){
            return Response.fail(e.getMessage());
        }
        return Response.ok();
    }

    @Override
    public Response<Boolean> findUserByPhoneNumber(String phoneNumber) {
        Integer count;
        try{
            count = userDetailService.findUserByPhoneNumber(phoneNumber);
        }catch (Exception e){
            return Response.fail(e.getMessage());
        }
        if(count==1){
            return Response.ok();
        }else{
            return Response.fail("没查到该用户");
        }
    }
}
