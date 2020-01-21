package wzy.graduate.project.anfaoc.service.timedtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.common.model.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;

import java.time.LocalDateTime;
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


    @Scheduled(fixedRate = 3000)
    public void updateNewsTask(){
        List<NewsDetail> urlList = JsoupUtil.updateNewsLibrary();
    }

}
