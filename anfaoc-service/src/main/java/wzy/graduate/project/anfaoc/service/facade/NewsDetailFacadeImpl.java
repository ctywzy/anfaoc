package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;

/**
 * @author wangzy
 */

@Slf4j
@Service
public class NewsDetailFacadeImpl implements NewsDetailFacade {

    @Autowired
    private NewsDetailService newsDetailService;

    @Override
    public void updateNews() {
        newsDetailService.updateNews();
    }
}
