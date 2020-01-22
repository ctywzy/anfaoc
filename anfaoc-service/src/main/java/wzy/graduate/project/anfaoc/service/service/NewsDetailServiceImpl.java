package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */
@Slf4j
@Service
public class NewsDetailServiceImpl implements NewsDetailService {


    @Override
    public void updateNews(List<NewsDetail> newsList) {
        log.info("更新新闻了");
    }

    @Override
    public void replaceTagNameWithId(List<NewsDetailDTO> newsDetailDTOS) {
        log.info("将标签名称改为id");
    }
}
