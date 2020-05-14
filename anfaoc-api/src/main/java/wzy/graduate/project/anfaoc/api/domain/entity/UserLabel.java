package wzy.graduate.project.anfaoc.api.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author terminus
 */

@Data
@NoArgsConstructor
public class UserLabel implements Serializable {

    private static final long serialVersionUID = -2672220154516899905L;

    /**
     * 自增id
     **/
    private Long id;

    /**
     * 用户id
     **/
    private String userId;

    /**
     * 标签id
     **/
    private String labelId;

    /**
     * 关注时间
     **/
    private String createTime;
}
