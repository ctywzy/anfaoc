package wzy.graduate.project.anfaoc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangzy
 * @Date 2019-12-31
 */

@Data
@ToString
public class NewsDetailDTO implements Serializable {

    private static final long serialVersionUID = -5597074539622169471L;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String Content;

    @ApiModelProperty("文章标签")
    private List<String> labels;
}
