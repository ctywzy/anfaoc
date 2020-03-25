package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author wangzy
 * @desc 管理标签的dao
 */

@Mapper
public interface LabelDetailDao {

    /**
     * @Description 插入标签
     * @Date  2020/3/13
     * @Param
     * @return
     **/

    /**
     * @Description 查询名称返回Id列表
     * @Date  2020/1/22
     **/
    List<LabelDetail> findByNames(Map<String,Object> criteria);

    /**
     * @Description 根据name查询标签
     * @Date  2020/3/23
     **/
    LabelDetail findByName(Map<String,Object> criteria);

    /**
     * @Description 更新所有标签的热度指数
     * @Date  2020/3/13
     **/
    Boolean updateLabelNumber(LabelDetail labelDetail);

    /**
     * @Description  插入标签
     * @Date  2020/3/23
     **/
    Long addLabelDetail(LabelDetail labelDetail);
}
