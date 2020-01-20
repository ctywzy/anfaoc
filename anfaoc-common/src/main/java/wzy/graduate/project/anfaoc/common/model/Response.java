package wzy.graduate.project.anfaoc.common.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author wangzy
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 5782124897007642436L;

    /**
     * 是否调用成功
     **/
    private boolean success;

    /**
     * 成功时返回的结果集
     **/
    private T result;

    /**
     * 不成功时返回的错误信息
     **/
    private String error;

    public boolean isSuccess(){
        return this.success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public T getResult(){
        return this.result;
    }

    public void setResult(T result){
        this.success = true;
        this.result = result;
    }

    public String getError(){
        return this.error;
    }

    public void setError(String error){
        this.success = false;
        this.error = error;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("success", success)
                .add("result", result)
                .add("error", error)
                .omitNullValues()
                .toString();
    }

    public static <T> Response<T> ok(T data){
        Response<T> resp = new Response<>();
        resp.setResult(data);
        return resp;
    }

    public static <T> Response<T> ok(){
        Response<T> resp = new Response<>();
        resp.setResult(null);
        return resp;
    }

    public static <T> Response<T> fail(String error){
        Response<T> resp = new Response<>();
        resp.setError(error);
        return resp;
    }
}
