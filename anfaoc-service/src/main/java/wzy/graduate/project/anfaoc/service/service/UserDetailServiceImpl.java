package wzy.graduate.project.anfaoc.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.api.service.UserDetailService;
import wzy.graduate.project.anfaoc.service.dao.UserDetailDao;

import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailDao.findAllUser();
    }
}
