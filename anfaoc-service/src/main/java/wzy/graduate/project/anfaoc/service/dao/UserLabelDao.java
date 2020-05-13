package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;

/**
 * @author wangzy
 */

@Mapper
public interface UserLabelDao {

    void insert(UserLabel detail);
}
