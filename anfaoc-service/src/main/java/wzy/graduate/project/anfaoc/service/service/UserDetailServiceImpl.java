package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.service.dao.UserDetailDao;

import java.util.HashMap;
import java.util.List;

/**
 * @Description 用户详情service
 * @author wangzy
 * @Date  2019/12/10
 **/

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailService{

    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    public List<UserDetail> getAllUserDetail() {
        log.info("service:显示");
        return userDetailDao.findAllUser();
    }

    @Override
    public boolean register(UserDetail userDetail) {
        try{
            userDetailDao.create(userDetail);
        }catch (Exception e){
            log.info("用户插入错误:{}",e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return true;
    }

    @Override
    public UserDetail findUserByPhoneNumber(String phoneNumber) {
        return userDetailDao.findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public UserDetail findUserByUserId(String userId) {
        return userDetailDao.findUserByUserId(userId);
    }
}
