package wzy.graduate.project.anfaoc.service.service;

import com.google.common.collect.Maps;
import wzy.graduate.project.anfaoc.service.convert.LabelDetailConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.service.LabelDetailService;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;
import wzy.graduate.project.anfaoc.service.dao.LabelDetailDao;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        try{
            labelDetails = labelDetailDao.findByNames(map);
        }catch (Exception e){
            log.info("exchageNameToId fail:{}",e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return labelDetails;
    }

    @Override
    public List<String> getLabelNameById(List<String> ids) {
        List<LabelDetail> labelDetails = null;
        Map<String,Object> map = Maps.newHashMap();
        map.put("ids",ids);
        try{
            labelDetails = labelDetailDao.findByNames(map);
        }catch (Exception e){
            log.info("getLabelNameById fail:{}",e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        List<String> labelNames = labelDetails.stream()
                                              .map(LabelDetail::getLabelName)
                                              .collect(Collectors.toList());
        return labelNames;
    }

    @Override
    public Boolean updateLabelNumber(List<String> labels) {
        try{
            String nowDate = NewsUtil.getNowTime();
            labels.stream().forEach(
                label ->{
                    LabelDetail labelDetail = new LabelDetail();
                    labelDetail.setLabelName(label);
                    LabelDetail judge = labelDetailDao.findByName(LabelDetailConvert.labelDetailToMap(labelDetail));
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
