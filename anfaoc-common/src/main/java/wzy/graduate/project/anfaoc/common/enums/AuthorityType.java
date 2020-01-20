package wzy.graduate.project.anfaoc.common.enums;

import lombok.Getter;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@Getter
public enum  AuthorityType {

    ORDINARY(1,"普通用户"),
    VIP(2,"充值用户"),
    ADMIN(3,"管理员");

    private final Integer value;

    private final String desc;

    AuthorityType(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }
}
