package wzy.graduate.project.anfaoc.service.dao;

import org.apache.ibatis.annotations.Mapper;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsCollectionDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;

import java.util.List;

/**
 * @author wangzy
 */

@Mapper
public interface UserLabelDao {

    void insert(UserLabel detail);

    void delete(UserLabel userLabel);

    List<UserLabel> find(UserLabel userLabel);
}
