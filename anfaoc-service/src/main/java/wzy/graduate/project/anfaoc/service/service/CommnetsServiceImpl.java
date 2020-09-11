package wzy.graduate.project.anfaoc.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.Comments;
import wzy.graduate.project.anfaoc.api.service.CommentsService;
import wzy.graduate.project.anfaoc.service.dao.CommentsDao;

import java.util.List;

/**
 * @author wangzy
 */

@Service
@Slf4j
public class CommnetsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public void addComments(Comments comments) {
        commentsDao.insert(comments);
    }

    @Override
    public List<Comments> getAllCommnets(Long newsId) {
       return commentsDao.getAllCommnets(String.valueOf(newsId));
    }
}
