package wzy.graduate.project.anfaoc.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangzy
 * @desc 标签相关的数据传输模型
 */

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDetailDTO implements Serializable {

    private static final long serialVersionUID = 1037451440177872607L;

    @ApiModelProperty("标签的自增id")
    private Long id;

    @ApiModelProperty("标签的名称")
    private String lableName;

    @ApiModelProperty("标签指数")
    private String labelNum;

    @ApiModelProperty("标签的创建时间")
    private Date createTime;

}
