package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */

public interface LableDetailService {

    /**
     * @Description 将标签的名字改为id
     * @Date  2020/1/22
     **/
    List<LabelDetail> exchageNameToId(NewsDetailDTO newsDetailDTOS);
}
