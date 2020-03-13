package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;

import java.util.List;

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
    List<LabelDetail> findByName(List<String> labelNames);

    /**
     * @Description 更新所有标签的热度指数
     * @Date  2020/3/13
     **/
    Boolean updateLableNumber(List<String> lableNames);
}
