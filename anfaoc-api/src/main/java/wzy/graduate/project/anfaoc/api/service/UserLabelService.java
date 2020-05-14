package wzy.graduate.project.anfaoc.api.service;

import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;

import java.util.List;

public interface UserLabelService {
    
    void create(UserLabel userLabel);

    void delete(UserLabel userLabel);

    List<UserLabel> find(UserLabel userLabel);

}
