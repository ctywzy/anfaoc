package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangzy
 * @desc 管理标签的dao
 */

@Mapper
public interface LabelDetailDao {

    /**
     * @Description 查询名称返回Id列表
     * @Date  2020/1/22
     **/
    List<Long> getIdFromName(List<String> labelNames);

}
