package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;

import java.util.List;
import java.util.Map;


/**
 * @author wangzy
 * @desc 管理新闻信息的dao
 */

@Mapper
public interface NewsDetailDao {

    /**
     * @Description 向数据库中插入新闻
     * @Date  2020/3/11
     **/
    Boolean insertNews(NewsDetail newsDetail);

    /**
     * @Description 判断是否存储过
     * @Date  2020/3/24
     **/
    NewsDetail judgeNewPresence(NewsDetail newsDetail);

    /**
     * @Description 出现多次更新热点值
     * @Date  2020/3/24
     **/
    void updateNewNum(NewsDetail newsDetail);

    /**
     * @Description 查询数据库中的新闻
     * @Date  2020/4/20
     **/
    List<NewsDetail> paging(Map<String, Object> criteria);

    /**
     * @Description 获取新闻
     * @Date  2020/5/12
     **/
    NewsDetail getNewsDetail(Map<String, Object> criteria);

    /**
     * @Description 查看次数更新
     * @Date  2020/5/13
     **/
    void addPageViews(Map<String, Object> criteria);
}
