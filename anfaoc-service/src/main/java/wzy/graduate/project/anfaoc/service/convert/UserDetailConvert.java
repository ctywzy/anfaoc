package wzy.graduate.project.anfaoc.service.convert;

import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.common.enums.AuthorityType;
import wzy.graduate.project.anfaoc.common.util.NewsUtil;

/**
 * @description 用户模型转换类
 * @author wangzy
 */
public class UserDetailConvert {

    public static UserDetail modelConvert(UserDetailDTO userDetailDTO){
        return UserDetail.builder()
                         .userName(userDetailDTO.getUserName())
                         .userPassword(userDetailDTO.getUserPassword())
                         .userAuthority(AuthorityType.ORDINARY)
                         .phoneNumber(userDetailDTO.getPhoneNumber())
                         .createTime(NewsUtil.getNowTime())
                         .build();

    }
}
