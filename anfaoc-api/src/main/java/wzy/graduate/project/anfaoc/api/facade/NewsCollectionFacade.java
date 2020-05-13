package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.domain.dto.NewsCollectionDTO;
import wzy.graduate.project.anfaoc.common.model.Response;

import java.util.List;

/**
 * @Author wangzy
 **/
public interface NewsCollectionFacade {

    /**
     * @Description 增加收藏
     * @Date  2020/5/12
     **/
    Response<Boolean> addNewsCollection(NewsCollectionDTO newsCollectionDTO);

    /**
     * @Description 获取用户收藏的新闻id
     * @Date  2020/5/13
     **/
    List<String> getAllColNewsId(String userId);
}
