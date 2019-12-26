package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.model.UserDetail;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

public interface UserDetailFacade {

    /**
     * @Description 查询所有的用户信息
     * @Date  2019/12/10
     * @Param
     * @return
     **/
    Response<List<UserDetail>> getAllUserDetail();

    /**
     * @Description 用户注册
     * @Date  2019/12/26
     * @Param
     * @return
     **/
    Response<Boolean> register(UserDetail userDetail);
}
