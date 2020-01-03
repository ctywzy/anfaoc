package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.UserDetail;

import java.util.HashMap;
import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

public interface UserDetailService {



    /**
     * @Description 查询所有的用户信息
     * @Date  2019/12/10
     * @Param
     * @return
     **/
    List<UserDetail> getAllUserDetail();

    /**
     * @Description 注册用户
     * @Date  2019/12/26
     * @Param
     * @return
     **/
    boolean register(HashMap<String, Object> criteria);

    /**
     * @Description 根据电话号码查询用户
     * @Date  2019/12/26
     * @Param
     * @return
     **/
    UserDetail findUserByPhoneNumber(String phoneNumber);
}
