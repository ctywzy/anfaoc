package wzy.graduate.project.anfaoc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetailDTO implements Serializable {

    private static final long serialVersionUID = -5597074539622169471L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("文章地址")
    private String newUrl;

    @ApiModelProperty("文章标题")
    private String newTitle;

    @ApiModelProperty("文章内容")
    private List<ParaEntity> newParas;

    @ApiModelProperty("文章标签")
    private List<String> newLabels;

    @ApiModelProperty("文章评论")
    private List<Long> commentsId;

    @ApiModelProperty("文章抓取时间")
    private String createTime;

    @ApiModelProperty("文章浏览量")
    private Long pageViews;

    @ApiModelProperty("文章热度")
    private Long heatNumber;

    @ApiModelProperty("文章段落内容")
    private String newsFinalPara;

    @ApiModelProperty("预览内容")
    private String preViewPara;

    @ApiModelProperty("用户页面预览")
    private  String userPreView;

    @ApiModelProperty("评论列表")
    private List<String> comments;

    @ApiModelProperty("评论人姓名")
    private List<String> commentsName;

    @ApiModelProperty("评论数")
    private String commentsNum;
}
