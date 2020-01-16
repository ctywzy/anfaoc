package wzy.graduate.project.anfaoc.common.model.entity;

import lombok.Data;
import wzy.graduate.project.anfaoc.common.enums.ParaType;

/**
 * @author wangzy
 * @Descrption 段落中保存内容的实体
 */

@Data
public class ParaEntity {

    /** 文段类型 **/
    private ParaType type;

    /** 内容 **/
    private String content;
}
