package wzy.graduate.project.anfaoc.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@Builder
public class LabelDetail implements Serializable {

    private static final long serialVersionUID = 7622301422947718173L;

    /** 标签的自增 **/
    private Long id;

    /** 标签的名称 **/
    private String labelName;

    /** 标签指数 **/
    private Long labelNum;

    /** 标签的创建时间 **/
    private Date createTime;
}
