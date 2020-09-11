package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;

import java.util.List;

/**
 * @author wangzy
 * @Description 新闻收藏表
 * @Date  2020/5/12
 **/

@Mapper
public interface NewsCollectionDao {

    void insert(NewsCollectionDetail detail);

    NewsCollectionDetail oneJudge(NewsCollectionDetail detail);

    List<NewsCollectionDetail> getAllColNews(@Param("userId") String userId);
}
