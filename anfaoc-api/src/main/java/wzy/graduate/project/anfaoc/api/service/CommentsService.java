package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.Comments;

import java.util.List;

public interface CommentsService {

    /**
     * @Description 插入评论
     * @Date  2020/5/13
     **/
    void addComments(Comments comments);

    List<Comments> getAllCommnets(Long newId);
}
