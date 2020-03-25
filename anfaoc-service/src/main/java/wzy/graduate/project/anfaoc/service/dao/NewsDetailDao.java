package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;


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
}
