package wzy.graduate.project.anfaoc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangzy
 * @Date 2019-12-31
 */

@Data
@ToString
@Builder
public class NewsDetailDTO implements Serializable {

    private static final long serialVersionUID = -5597074539622169471L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private List<ParaEntity> paras;

    @ApiModelProperty("文章标签")
    private List<String> labels;

    @ApiModelProperty("文章评论")
    private List<Long> commentsId;

    @ApiModelProperty("文章抓取时间")
    private Date createTime;

    @ApiModelProperty("文章浏览量")
    private Long pageViews;

    @ApiModelProperty("文章热度")
    private Long heatNumber;
}
