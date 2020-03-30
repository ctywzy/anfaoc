package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.service.convert.NewsDetailConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.api.service.NewsDetailService;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;

import java.util.ArrayList;
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
            newsDetailService.updateNews(newsList);
        }catch (Exception e){
            log.error("updateNews fail:{}",e.getMessage());

        }
    }

    @Override
    public Response<List<NewsDetailDTO>> newsPage(Integer pageNo) {

        List<NewsDetailDTO> newsDetailDTOS = Lists.newArrayList();

        try{

        }catch (Exception e){

        }
        return Response.ok(newsDetailDTOS);
    }

    @Override
    public Response<List<NewsDetailDTO>> newsPageRecommend(Integer pageNo) {
        List<NewsDetailDTO> newsDetailDTOS = Lists.newArrayList();

        try{

        }catch (Exception e){

        }
        return Response.ok(newsDetailDTOS);
    }

    @Override
    public Response<List<NewsDetailDTO>> newsPageLike(Integer pageNo) {
        List<NewsDetailDTO> newsDetailDTOS = Lists.newArrayList();

        try{

        }catch (Exception e){

        }
        return Response.ok(newsDetailDTOS);
    }

}
