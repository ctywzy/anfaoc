package wzy.graduate.project.anfaoc.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;
import wzy.graduate.project.anfaoc.api.service.UserLabelService;
import wzy.graduate.project.anfaoc.service.dao.LabelDetailDao;
import wzy.graduate.project.anfaoc.service.dao.UserLabelDao;

import java.util.List;

/**
 * @author wangzy
 */

@Service
@Slf4j
public class UserLabelServiceImpl implements UserLabelService {

    @Autowired
    private UserLabelDao userLabelDao;

    @Override
    public void create(UserLabel userLabel) {
        userLabelDao.insert(userLabel);

    }

    @Override
    public void delete(UserLabel userLabel) {
        userLabelDao.delete(userLabel);
    }

    @Override
    public List<UserLabel> find(UserLabel userLabel) {
       return userLabelDao.find(userLabel);
    }
}
