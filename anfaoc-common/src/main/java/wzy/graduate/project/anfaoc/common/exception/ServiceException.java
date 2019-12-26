package wzy.graduate.project.anfaoc.common.exception;

/**
 * @author wangzy
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 1192578981995711145L;

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }

}
