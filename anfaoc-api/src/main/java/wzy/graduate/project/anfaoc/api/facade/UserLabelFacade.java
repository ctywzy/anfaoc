package wzy.graduate.project.anfaoc.api.facade;

import wzy.graduate.project.anfaoc.api.domain.dto.UserLabelDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;

import java.util.List;

public interface UserLabelFacade {

    /**
     * @Description 添加
     * @Date  2020/5/13
     **/
    void create(UserLabelDTO userLabelDTO);

    /**
     * @Description 删除
     * @Date  2020/5/13
     **/
    void deleteLabel(UserLabelDTO userLabelDTO);

    /**
     * @Description 根据userId获取
     * @Date  2020/5/14
     **/
    List<String> findLabelByUserId(String userId);
}
