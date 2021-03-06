package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;
import java.util.Map;

/**
 * @author wangzy
 */
public interface NewsDetailService {
    /**
     * @Description 添加，或者说是更新新闻的方法
     * @Date  2020/1/20
     * @param newsList
     * */
    void updateNews(List<NewsDetail> newsList);

    /**
     * @Description 新闻的分页查询
     * @Date  2020/4/13
     * @Param
     **/
    List<NewsDetail> paging(Map<String, Object> criteria);

    /**
     * @Description 获取新闻详情
     * @Date  2020/5/12
     **/
    NewsDetail getNewsDetail(Map<String, Object> criteria);

    /**
     * @Description 浏览次数加1
     * @Date  2020/5/13
     **/
    void addPageViews(Map<String, Object> criteria);

    /**
     * @Description 收藏新闻获取
     * @Date  2020/5/13
     **/
    List<NewsDetail> colNews(Map<String, Object> criteria);
}
