package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */
public interface NewsDetailFacade {

    /**
     * @Description 更新新闻的接口，把新闻插入库中
     * @Date  2020/1/19
     *@param newsList */
    void updateNews(List<NewsDetailDTO> newsList);
}
