package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.service.dao.UserDetailDao;

import java.util.HashMap;
import java.util.List;

/**
 * @Description //TODO
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
    public boolean register(HashMap<String, Object> criteria) {
        return false;
    }

    @Override
    public UserDetail findUserByPhoneNumber(String phoneNumber) {
        return userDetailDao.findUserByPhoneNumber(phoneNumber);
    }
}
