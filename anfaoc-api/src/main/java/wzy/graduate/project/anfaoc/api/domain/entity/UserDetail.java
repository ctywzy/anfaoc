package wzy.graduate.project.anfaoc.api.domain.entity;

import lombok.*;
import wzy.graduate.project.anfaoc.common.enums.AuthorityType;

import java.io.Serializable;

/**
 * @Description 用户详情
 * @author wangzy
 * @Date  2019/12/10
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 2808784558558815994L;

    /** 主键id **/
    private Long id;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String userPassword;

    /** 年龄 **/
    private Integer userAge;

    /** 用户类型 **/
    private AuthorityType userAuthority;

    /** 手机号 **/
    private Long phoneNumber;

    /** 注册时间 **/
    private String createTime;


}
