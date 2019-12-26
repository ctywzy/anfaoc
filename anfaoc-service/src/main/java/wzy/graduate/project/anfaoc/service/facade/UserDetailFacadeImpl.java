package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.ArrayList;
import java.util.List;

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

        }catch (ServiceException e){
            return Response.fail(e.getMessage());
        }
        return null;
    }
}
