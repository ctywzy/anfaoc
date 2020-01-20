package wzy.graduate.project.anfaoc.common.enums;

import lombok.Getter;

/**
 * @Description 段落类型枚举
 * @author wangzy
 * @Date  2019/12/10
 **/

@Getter
public enum  ParaType {

    PICTURE(1,"图片"),
    DESCRIPTION(2,"图片描述"),
    PARAGRAPH(3,"段落");

    private final Integer value;

    private final String desc;

    ParaType(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

}
