package wzy.graduate.project.anfaoc.api.Request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import wzy.graduate.project.anfaoc.common.enums.PagingType;

import java.io.Serializable;

/**
 * @Author Request
 * @Date 2020/4/13
 **/
@Data
public class NewsPagingRequest implements Serializable {

    private static final long serialVersionUID = -6199253197397260099L;

    @ApiModelProperty("页码")
    private Integer pagingNo;

    @ApiModelProperty("页面大小")
    private Integer pageSize;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("类型")
    private PagingType pagingType;
}
