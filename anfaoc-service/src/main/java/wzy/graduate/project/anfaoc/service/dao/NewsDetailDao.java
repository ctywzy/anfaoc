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
}
