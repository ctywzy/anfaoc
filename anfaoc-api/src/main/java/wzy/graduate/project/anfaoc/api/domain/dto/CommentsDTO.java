package wzy.graduate.project.anfaoc.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzy
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO implements Serializable {

    private static final long serialVersionUID = 7083700919385004621L;

    @ApiModelProperty("自增id")
    private Long id;

    @ApiModelProperty("新闻id")
    private String newsId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("日期")
    private String Date;
}
