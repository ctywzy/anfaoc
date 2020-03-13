package wzy.graduate.project.anfaoc.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangzy
 * @Description 文章结构实体
 * 对应的dto类 wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO
 */

@Data
@Builder
@ToString
public class NewsDetail implements Serializable {

    private static final long serialVersionUID = -3493556820465038415L;

    /** 文章主键自增id **/
    private Long id;

    /** 文章地址 **/
    private String newUrl;

    /** 文章标题 **/
    private String newTitle;

    /** 文章标签id **/
    private String newLabels;

    /** 文章段落内容 **/
    private String newParas;

    /** 文章被爬取的时间**/
    private Date createTime;

    /** 文章的评论 **/
    private String commentsId;

    /** 文章浏览量 **/
    private Long pageViews;

    /** 文章热度 **/
    private Long heatNumber;
}
