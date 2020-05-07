package wzy.graduate.project.anfaoc.common.enums;

import lombok.Getter;

/**
 * @Description 文章类型枚举类
 * @Date  2020/4/13
 * @Author wangzy
 **/
@Getter
public enum PagingType {

    LIKED(1,"喜欢类型"),
    ORDINARY(2,"普通类型");

    private final Integer value;

    private final String desc;


    PagingType(Integer value, String desc){
        this.desc = desc;
        this.value = value;
    }
}
