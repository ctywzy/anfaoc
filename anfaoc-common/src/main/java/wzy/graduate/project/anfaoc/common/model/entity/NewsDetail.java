package wzy.graduate.project.anfaoc.common.model.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author wangzy
 * @Description 文章结构实体
 */

@Data
@Builder
public class NewsDetail {

    /** 文章标题 **/
    private String title;

    /** 文章标签 **/
    private List<String> labels;

    /** 文章段落内容 **/
    private List<ParaEntity> paras;
}
