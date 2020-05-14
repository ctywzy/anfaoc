package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;
import wzy.graduate.project.anfaoc.service.util.MapUtil;

import java.util.*;

/**
 * @author wangzy
 */

@Slf4j
@Service
public class LabelDetailFacadeImpl implements LabelDetailFacade {

    @Autowired
    private LabelDetailService labelDetailService;

    @Override
    public void updateLabelDetail(List<NewsDetailDTO> newsListDTOs) {

        try{
            newsListDTOs.stream().map(NewsDetailDTO::getNewLabels).forEach(
                labels -> {
                    labelDetailService.updateLabelNumber(labels);
                }
            );
        }catch (Exception e){
            log.error("数据库插入异常:{}",e.getMessage());
        }
    }

    @Override
    public Response<List<LabelDetail>> getAllLabel(NewsPagingRequest request) {
        List<LabelDetail> labelDetails = new ArrayList<>();
        try{
            Map<String,Object> criteria = MapUtil.toLabelMap(request);

            labelDetails = labelDetailService.getAllLabel(criteria);
        }catch (Exception e){
            log.info("获取标签失败");
            return Response.fail("获取标签失败");
        }
        return Response.ok(labelDetails);
    }
}
