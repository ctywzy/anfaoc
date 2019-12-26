package wzy.graduate.project.anfaoc.common.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wangzy
 */
@Data
@ToString
public class SMSBalanceDetail implements Serializable {
    
    private static final long serialVersionUID = 4626328833732347360L;
    
    private int code;
    
    private String data;
}
