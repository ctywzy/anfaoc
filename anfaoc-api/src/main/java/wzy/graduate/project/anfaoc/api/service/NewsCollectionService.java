package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;

/**
 * @author wangzy
 */
public interface NewsCollectionService {

    /**
     * @Description 插入新闻
     * @Date  2020/5/12
     **/
    void addNewsCollection(NewsCollectionDetail detail);
}
