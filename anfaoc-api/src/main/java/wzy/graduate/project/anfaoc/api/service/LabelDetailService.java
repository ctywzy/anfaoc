package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */

public interface LabelDetailService {

    /**
     * @Description 将标签的名字改为id
     * @Date  2020/1/22
     **/
    List<LabelDetail> exchageNameToId(NewsDetailDTO newsDetailDTOS);

    /**
     * @Description 获取标签明
     * @Date  2020/5/11
     **/
    List<String> getLabelNameById(List<String> ids);

    /**
     * @Description 更新标签热度
     * @Date  2020/3/23
     * @return
     **/
    Boolean updateLabelNumber(List<String> labels);

}
