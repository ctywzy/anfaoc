package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@Service
public class UserDetailFacadeImpl implements UserDetailFacade {

    @Autowired
    private UserDetailService userDetailService;

    @Override
    public List<UserDetail> getAllUserDetail() {
//        UserDetail userDetail = new UserDetail();
//        List<UserDetail> list = new ArrayList<>();
//        userDetail.setId(1L);
//        userDetail.setPhoneNumber(123L);
//        userDetail.setUserName("小王");
//        list.add(userDetail);
        return userDetailService.getAllUserDetail();
    }
}
