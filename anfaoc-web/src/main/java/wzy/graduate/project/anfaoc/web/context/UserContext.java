package wzy.graduate.project.anfaoc.web.context;

import wzy.graduate.project.anfaoc.api.domain.UserDetail;

/**
 * @author wangzy
 */
public class UserContext {
    private static final ThreadLocal<UserDetail> userLocal = new ThreadLocal<>();

    public static void setUserLocal(UserDetail userDeatil){
        userLocal.set(userDeatil);
    }

    public static UserDetail getUserLocal(){
        return userLocal.get();
    }
}
