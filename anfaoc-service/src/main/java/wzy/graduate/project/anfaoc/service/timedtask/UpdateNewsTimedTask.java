package wzy.graduate.project.anfaoc.service.timedtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
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

    @Autowired
    private LabelDetailFacade labelDetailFacade;

    /**
     * @Description 每过8小时更新一次，这里计算的是热榜的新闻
     * @Date  2020/1/21
     **/
    @Scheduled(fixedRate = 28800000)
    public void updateNewsTask(){
        // 爬新闻
       // List<NewsDetailDTO> newsListDTOs = JsoupUtil.updateNewsLibrary();
        //存储或更新标签，规则是出现一次就+2，第一次出现为0
        //labelDetailFacade.updateLabelDetail(newsListDTOs);

        //存储新闻
        //newsDetailFacade.updateNews(newsListDTOs);

        //TODO 新闻量过大的时候删除部分 考虑 2000～4000中的某个数为阀值


        //TODO 如果用户登陆，跟新喜爱榜和推荐榜喜爱榜时自己选标签，推荐榜是我们根据用户常浏览标签推算

        // TODO 这里应该存在一个标签淘汰机制今天浏览了+ 1，未浏览考虑 - 1

    }



}
