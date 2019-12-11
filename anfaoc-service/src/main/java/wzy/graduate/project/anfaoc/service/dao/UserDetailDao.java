package wzy.graduate.project.anfaoc.service.dao;

import wzy.graduate.project.anfaoc.api.model.UserDetail;

import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

public interface UserDetailDao {

    List<UserDetail> findAllUser();
}
