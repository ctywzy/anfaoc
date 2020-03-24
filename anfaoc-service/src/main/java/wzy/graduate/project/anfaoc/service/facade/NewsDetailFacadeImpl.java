package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import convert.NewsDetailConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wangzy
 */

@Slf4j
@Service
public class NewsDetailFacadeImpl implements NewsDetailFacade {

    @Autowired
    private NewsDetailService newsDetailService;

    @Autowired
    private LabelDetailService labelDetailService;

    @Override
    public void updateNews(List<NewsDetailDTO> newsDetailDTOS) {
        List<NewsDetail> newsList = new ArrayList<>();

        try{
            //把标签名改为标签id

            for (NewsDetailDTO newsDetailDTO : newsDetailDTOS){

                List<LabelDetail> labelDetails = labelDetailService.exchageNameToId(newsDetailDTO);

                NewsDetail newsDetail = NewsDetailConvert.convertToNewsDetail(newsDetailDTO);

                NewsDetailConvert.addLabelDetails(newsDetail,labelDetails);
                newsList.add(newsDetail);
            }
            //TODO 新闻插入bug
            newsDetailService.updateNews(newsList);
        }catch (Exception e){
            log.error("数据库插入异常:{}",e.getMessage());

        }

    }
}
