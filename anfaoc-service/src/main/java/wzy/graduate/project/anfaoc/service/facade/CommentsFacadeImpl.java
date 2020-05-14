package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.dto.CommentsDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.Comments;
import wzy.graduate.project.anfaoc.api.facade.CommentsFacade;
import wzy.graduate.project.anfaoc.api.service.CommentsService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangzy
 */

@Service
@Slf4j
public class CommentsFacadeImpl implements CommentsFacade {

    @Autowired
    private CommentsService commentsService;

    @Override
    public Response<String> addComment(CommentsDTO commentsDTO) {

        try{
            Comments comments = new Comments();
            BeanUtils.copyProperties(commentsDTO,comments);
            comments.setCreateTime(NewsUtil.getNowTime());
            commentsService.addComments(comments);
        }catch (Exception e){
            log.info("评论添加失败:{}",commentsDTO);
            return Response.fail("评论添加失败");
        }
        return Response.ok(commentsDTO.getNewsId());
    }

    @Override
    public List<Comments> getAllCommnets(Long newId) {
        List<Comments> comments = new ArrayList<>();
        try{
            comments =  commentsService.getAllCommnets(newId);
        }catch (Exception e){
            log.info("获取评论失败:{}",newId);
            throw new ServiceException("获取评论失败");
        }
        return comments;
    }
}
