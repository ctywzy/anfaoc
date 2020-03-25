package wzy.graduate.project.anfaoc.service.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 新闻参数转化类
 * @Date  2020/3/13
 * @Author wangzy
 **/

@Slf4j
public class NewsDetailConvert {

    private static ObjectMapper mapper = new ObjectMapper();
    /**
     * @Description 视图层对象转换为业务层
     * @Date  2020/3/13
     **/
    public static NewsDetail convertToNewsDetail(NewsDetailDTO newsDetailDTO){

        NewsDetail newsDetail = null;
        try{
            newsDetail = NewsDetail.builder()
                    .createTime(NewsUtil.getNowTime())
                    .newUrl(newsDetailDTO.getNewUrl())
                    .newTitle(newsDetailDTO.getNewTitle())
                    .newParas(mapper.writeValueAsString(newsDetailDTO.getNewParas()))
                    .pageViews(0L)
                    .build();
        }catch (IOException e){
            log.info("json转换错误");
            throw new ServiceException("json转换错误");
        }

        return newsDetail;
    }

    /**
     * @Description 加入标签信息
     * @Date  2020/3/13
     **/
    public static void addLabelDetails(NewsDetail newsDetail, List<LabelDetail> labelDetails) throws JsonProcessingException {
        List<Long> labelIds = labelDetails.stream().map(LabelDetail::getId).collect(Collectors.toList());
        newsDetail.setNewLabels(mapper.writeValueAsString(labelIds));

        //通过标签指数，计算文章热度指数
        Long heatNumber = new Long("0");
        for(LabelDetail labelDetail : labelDetails){
            heatNumber += labelDetail.getLabelNum();
        }
        newsDetail.setHeatNumber(heatNumber);
    }
}
