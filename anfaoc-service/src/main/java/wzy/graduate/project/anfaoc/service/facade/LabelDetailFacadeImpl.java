package wzy.graduate.project.anfaoc.service.facade;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

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
}
