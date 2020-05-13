package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.domain.dto.NewsCollectionDTO;
import wzy.graduate.project.anfaoc.common.model.Response;

/**
 * @Author wangzy
 **/
public interface NewsCollectionFacade {

    /**
     * @Description 增加收藏
     * @Date  2020/5/12
     **/
    Response<Boolean> addNewsCollection(NewsCollectionDTO newsCollectionDTO);

}
