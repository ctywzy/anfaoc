package wzy.graduate.project.anfaoc.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangzy
 * @desc 标签相关的实体类
 */

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDetail implements Serializable {

    private static final long serialVersionUID = 7622301422947718173L;

    /** 标签的自增 **/
    private Long id;

    /** 标签的名称 **/
    private String lableName;

    /** 标签指数 **/
    private String labelNum;

    /** 标签的创建时间 **/
    private Date createTime;
}
