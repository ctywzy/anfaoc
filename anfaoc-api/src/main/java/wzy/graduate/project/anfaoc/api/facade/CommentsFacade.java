package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.domain.dto.CommentsDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.Comments;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.List;

/**
 * @author wangzy
 */
public interface CommentsFacade {

    /**
     * @Description //添加评论
     * @Date  2020/5/13
     **/
    Response<String> addComment(CommentsDTO commentsDTO);

    /**
     * @Description 获取对应的所有评论
     * @Date  2020/5/13
     **/
    List<Comments> getAllCommnets(Long newId);
}
