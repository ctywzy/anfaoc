package wzy.graduate.project.anfaoc.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzy
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsCollectionDTO implements Serializable {

    private static final long serialVersionUID = 5859164943072364935L;

    @ApiModelProperty("自增id")
    private Long id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("新闻id")
    private String newsId;

    @ApiModelProperty("收藏时间")
    private String createTime;
}
