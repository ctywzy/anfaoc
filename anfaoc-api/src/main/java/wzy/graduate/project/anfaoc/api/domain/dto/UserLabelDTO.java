package wzy.graduate.project.anfaoc.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzy
 */

@Data
@NoArgsConstructor
public class UserLabelDTO implements Serializable {

    private static final long serialVersionUID = 4631694785390267088L;

    @ApiModelProperty("自增id")
    private Long id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("标签id")
    private String lableId;

    @ApiModelProperty("关注时间")
    private String createTime;
}
