package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wzy.graduate.project.anfaoc.api.domain.entity.Comments;

import java.util.List;

/**
 * @author wangzy
 */
@Mapper
public interface CommentsDao {

    void insert(Comments detail);

    List<Comments> getAllCommnets(@Param("newsId") String newsId);
}
