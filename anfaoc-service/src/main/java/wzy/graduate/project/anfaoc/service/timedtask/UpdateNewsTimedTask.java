package wzy.graduate.project.anfaoc.service.timedtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzy
 * @description 用来每天拉取新闻的定时任务
 */

@Component
@Slf4j
public class UpdateNewsTimedTask {

    @Autowired
    private NewsDetailFacade newsDetailFacade;

    /**
     * @Description 每过8小时更新一次
     * @Date  2020/1/21
     **/
    @Scheduled(fixedRate = 28800000)
    public void updateNewsTask(){
        // 爬新闻
        List<NewsDetailDTO> newsListDTOs = JsoupUtil.updateNewsLibrary();



        newsDetailFacade.updateNews(newsListDTOs);
    }

}
