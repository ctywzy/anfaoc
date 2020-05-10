package wzy.graduate.project.anfaoc.common.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 检查电话号码是否符合要求
 * @Date  2020/5/10
 * @Author wangzy
 **/

@Data
public class PhoneCheckResponse {

    /**
     * 错误信息
     **/
    private String msg;

    /**
     * 是否合规
     **/
    private boolean result;
}
