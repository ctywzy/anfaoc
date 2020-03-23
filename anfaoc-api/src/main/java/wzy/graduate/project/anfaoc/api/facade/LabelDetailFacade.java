package wzy.graduate.project.anfaoc.api.facade;

import lombok.extern.slf4j.Slf4j;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

/**
 * @author wangzy
 */

public interface LabelDetailFacade {

    /**
     * @Description 更新标签信息到数据库中
     * @Date  2020/3/23
     **/
    void updateLabelDetail(List<NewsDetailDTO> newsListDTOs);
}
