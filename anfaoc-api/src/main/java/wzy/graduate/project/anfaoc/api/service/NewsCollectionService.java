package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;

import java.util.List;

/**
 * @author wangzy
 */
public interface NewsCollectionService {

    /**
     * @Description 插入新闻
     * @Date  2020/5/12
     **/
    void addNewsCollection(NewsCollectionDetail detail);

    /**
     * @Description 是否已经存在
     * @Date  2020/5/13
     **/
    Boolean newsCollectionOneJudge(NewsCollectionDetail detail);

    /**
     * @Description 根据用户id查询
     * @Date  2020/5/13
     **/
    List<NewsCollectionDetail> getAllColNews(String userId);
}
