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
    Integer pagingNo;

    @ApiModelProperty("页面大小")
    Integer pageSize;

    @ApiModelProperty("类型")
    PagingType pagingType;
}
