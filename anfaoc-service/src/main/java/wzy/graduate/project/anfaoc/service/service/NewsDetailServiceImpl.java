package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.service.dao.NewsDetailDao;

import java.util.List;

/**
 * @author wangzy
 */
@Slf4j
@Service
public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    private NewsDetailDao newsDetailDao;

    @Override
    public void updateNews(List<NewsDetail> newsList) {
        log.info("更新新闻了");
    }

}
