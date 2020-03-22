package convert;

import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.Date;
import java.util.List;

/**
 * @Description 新闻参数转化类
 * @Date  2020/3/13
 * @Author wangzy
 **/

public class NewsDetailConvert {

    /**
     * @Description 视图层对象转换为业务层
     * @Date  2020/3/13
     **/
    public static NewsDetail convertToNewsDetail(NewsDetailDTO newsDetailDTO){
        NewsDetail newsDetail = NewsDetail.builder()
                                          .createTime(new Date())
                                          .newUrl(newsDetailDTO.getNewUrl())
                                          .newTitle(newsDetailDTO.getNewTitle())
                                        //这个热度的计算公式该怎么设计
                                          .heatNumber(1000L)
                                          .pageViews(0L)
                                          .build();
        return newsDetail;
    }

    /**
     * @Description 加入标签信息
     * @Date  2020/3/13
     **/
    public static void addLabelDetails(NewsDetail newsDetail, List<LabelDetail> labelDetails) {

    }
}
