package wzy.graduate.project.anfaoc.api.domain.entity;

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
public class NewsCollectionDetail implements Serializable {

    private static final long serialVersionUID = -9119959137068497721L;

    /**
     * 自增id
     **/
    private Long id;

    /**
     * 用户id
     **/
    private String userId;

    /**
     * 新闻id
     **/
    private String newsId;

    /**
     * 收藏时间
     **/
    private String createTime;
}
