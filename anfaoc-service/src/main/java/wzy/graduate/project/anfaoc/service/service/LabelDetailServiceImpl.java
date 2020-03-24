package wzy.graduate.project.anfaoc.service.service;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.util.DateUtil;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;
import wzy.graduate.project.anfaoc.service.dao.LabelDetailDao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangzy
 */

@Slf4j
@Service
public class LabelDetailServiceImpl implements LabelDetailService{

    @Autowired
    private LabelDetailDao labelDetailDao;

    @Override
    public List<LabelDetail> exchageNameToId(NewsDetailDTO newsDetailDTOS) {
        List<LabelDetail> labelDetails = null;
        Map<String,Object> map = Maps.newHashMap();
        map.put("labelNames",newsDetailDTOS.getNewLabels());
        //TODO bug修复
        try{
            labelDetails = labelDetailDao.findByNames(map);
        }catch (Exception e){
            log.info("exchageNameToId fail:{}",e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return labelDetails;
    }

    @Override
    public Boolean updateLabelNumber(List<String> labels) {
        try{
            String nowDate = NewsUtil.getNowTime();
            labels.stream().forEach(
                label ->{
                    LabelDetail labelDetail = new LabelDetail();
                    labelDetail.setLabelName(label);
                    LabelDetail judge = labelDetailDao.findByName(labelDetail);
                    if(Objects.isNull(judge)){
                        labelDetail.setLabelNum(0L);
                        labelDetail.setCreateTime(nowDate);
                        labelDetailDao.addLabelDetail(labelDetail);
                    }else{
                        labelDetailDao.updateLabelNumber(labelDetail);
                    }
                }
            );
        }catch (Exception e){
            log.info("updateLabelNumber fail :{}",e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return Boolean.TRUE;
    }
}
