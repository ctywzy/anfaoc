package wzy.graduate.project.anfaoc.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wzy.graduate.project.anfaoc.common.enums.ParaType;

import java.io.Serializable;

/**
 * @author wangzy
 * @Descrption 段落中保存内容的实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParaEntity implements Serializable {

    private static final long serialVersionUID = 3276761913218668518L;

    /** 文段类型 **/
    private ParaType type;

    /** 内容 **/
    private String content;
}
