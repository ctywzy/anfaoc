package wzy.graduate.project.anfaoc.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.service.LableDetailService;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.service.dao.LabelDetailDao;

import java.util.List;

/**
 * @author wangzy
 */

public class LabelDetailServiceImpl implements LableDetailService{

    @Autowired
    private LabelDetailDao labelDetailDao;

    @Override
    public List<LabelDetail> exchageNameToId(NewsDetailDTO newsDetailDTOS) {

        return labelDetailDao.findByName(newsDetailDTOS.getNewLabels());
    }
}
