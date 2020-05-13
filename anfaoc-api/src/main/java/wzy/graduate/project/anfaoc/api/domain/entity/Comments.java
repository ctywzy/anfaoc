package wzy.graduate.project.anfaoc.api.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangzy
 */
@Data
@NoArgsConstructor
public class Comments implements Serializable {

    private static final long serialVersionUID = 6584391043799923453L;

    /**
     * 自增id
     **/
    private Long id;

    /**
     * 新闻id
     **/
    private String newsId;

    /**
     * 评论内容
     **/
    private String content;

    /**
     * 日期
     **/
    private String createTime;
}
