package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.api.service.LableDetailService;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzy
 */

@Slf4j
@Service
public class NewsDetailFacadeImpl implements NewsDetailFacade {

    @Autowired
    private NewsDetailService newsDetailService;

    @Autowired
    private LableDetailService lableDetailService;

    @Override
    public void updateNews(List<NewsDetailDTO> newsDetailDTOS) {
        List<NewsDetail> newsList = new ArrayList<>();

        NewsUtil newsUtil = new NewsUtil();

        try{
            //把标签名改为标签id
            newsDetailService.replaceTagNameWithId(newsDetailDTOS);
            for (NewsDetailDTO newsDetailDTO : newsDetailDTOS){
                NewsDetail newsDetail = NewsDetail.builder()
                        .createTime(new Date())
                        .newTitle(newsDetailDTO.getTitle())
                        .newLabelsId(newsUtil.getLablesIdString(newsDetailDTO.getLabels()))
                        .newParas(newsUtil.getParasString(newsDetailDTO.getParas()))
                        //这个热度的计算公式该怎么设计
                        .heatNumber(1000L)
                        .pageViews(0L)
                        .build();
                newsList.add(newsDetail);
            }
            newsDetailService.updateNews(newsList);
        }catch (Exception e){
            log.error("数据库插入异常:{}",e.getMessage());

        }

    }
}
