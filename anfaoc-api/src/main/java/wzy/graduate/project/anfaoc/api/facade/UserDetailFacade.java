package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.List;

/**
 * @Description 用户facade
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
    Response<Boolean> register(UserDetailDTO userDetailDTO);

    /**
     * @Description 根据电话号码查询用户是否存在
     * @Date  2019/12/26
     * @Param
     * @return
     **/
    Response<UserDetail> findUserByPhoneNumber(String phoneNumber);

    /**
     * @Description 根据电话好号码和密码判断登陆是否成功
     * @Date  2020/1/3
     * @Param
     * @return
     **/
    Response<UserDetail> loginByPhoneNumber(String phoneNumber, String password);

    /**
     * @Description 根据用户id获取用户信息
     * @Date  2020/5/13
     **/
    Response<UserDetail> findUserByUserId(String userId);
}
