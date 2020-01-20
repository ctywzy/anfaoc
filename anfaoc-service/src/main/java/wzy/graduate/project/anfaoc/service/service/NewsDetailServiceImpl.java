package wzy.graduate.project.anfaoc.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;

/**
 * @author wangzy
 */
@Slf4j
@Service
public class NewsDetailServiceImpl implements NewsDetailService {

    @Override
    public void updateNews() {
        log.info("更新新闻了");
       // System.out.println("更新新闻了");
    }
}
