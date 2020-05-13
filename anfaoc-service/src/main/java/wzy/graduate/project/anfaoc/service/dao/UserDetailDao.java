package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;

import java.util.List;

/**
 * @Description 管理用户信息的dao
 * @author wangzy
 * @Date  2019/12/10
 **/

@Mapper
public interface UserDetailDao {

    /**
     * @Description 获取所有用户信息
     * @Date  2020/1/3
     * @Param
     * @return
     **/
    List<UserDetail> findAllUser();

    /**
     * @Description 获取该电话对应的用户信息
     * @Date  2020/1/3
     * @Param
     * @return
     **/
    UserDetail findUserByPhoneNumber(String phoneNumber);

    /**
     * @Description 注册新用户
     * @Date  2020/3/25
     **/
    void create(UserDetail userDetail);

    /**
     * @Description 根据userId查询用户
     * @Date  2020/5/13
     **/
    UserDetail findUserByUserId(String userId);
}
