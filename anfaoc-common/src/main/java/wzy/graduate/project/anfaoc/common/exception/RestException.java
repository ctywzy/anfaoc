package wzy.graduate.project.anfaoc.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author wangzy
 */
public class RestException extends RuntimeException{
    private static final long serialVersionUID = 5519700249309174066L;

    /**
     * @Description 状态码
     **/
    private HttpStatus httpStatus;

    /**
     * 错误信息
     **/
    private String message;

    /**
     * 参数列表
     **/
    private String[] params;

    public RestException(HttpStatus httpStatus,String message,String... params){
        super(message);

        this.httpStatus = httpStatus;
        this.message = message;
        this.params = params;
    }

    public RestException(String message,String... params){
        this(HttpStatus.INTERNAL_SERVER_ERROR,message,params);
    }
}
