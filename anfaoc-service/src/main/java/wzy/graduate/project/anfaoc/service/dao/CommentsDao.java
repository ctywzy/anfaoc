package wzy.graduate.project.anfaoc.service.dao;

import wzy.graduate.project.anfaoc.api.domain.entity.Comments;

import java.util.List;

/**
 * @author wangzy
 */
public interface CommentsDao {

    void insert(Comments detail);

    List<Comments> getAllCommnets(Long newId);
}
