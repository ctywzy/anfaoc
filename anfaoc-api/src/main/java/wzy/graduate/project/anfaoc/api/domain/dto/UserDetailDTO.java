package wzy.graduate.project.anfaoc.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import wzy.graduate.project.anfaoc.common.enums.AuthorityType;

import java.io.Serializable;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@Data
@ToString
public class UserDetailDTO implements Serializable {

    private static final long serialVersionUID = 6162253613737704122L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("年龄")
    private Integer userAge;

    @ApiModelProperty("用户类型")
    private AuthorityType userAuthority;

    @ApiModelProperty("手机号")
    private Long phoneNumber;
}
