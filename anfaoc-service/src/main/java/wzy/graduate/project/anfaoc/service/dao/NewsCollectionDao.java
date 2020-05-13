package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;

/**
 * @author wangzy
 * @Description 新闻收藏表
 * @Date  2020/5/12
 **/

@Mapper
public interface NewsCollectionDao {

    void insert(NewsCollectionDetail detail);
}
