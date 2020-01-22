package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */
public interface NewsDetailService {
    /**
     * @Description 添加，或者说是更新新闻的方法
     * @Date  2020/1/20
     * @param newsList
     * */
    void updateNews(List<NewsDetail> newsList);

    /**
     * @Description 修改标签名为标签id
     * @Date  2020/1/22
     * @Param
     **/
    void replaceTagNameWithId(List<NewsDetailDTO> newsDetailDTOS);
}
