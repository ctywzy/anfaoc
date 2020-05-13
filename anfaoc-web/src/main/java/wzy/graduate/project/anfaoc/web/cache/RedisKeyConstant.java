package wzy.graduate.project.anfaoc.web.cache;

/**
 * @description redis键值
 * @author wangzy
 */
public class RedisKeyConstant {
    private static final String cache = "CACHE:";

    private static final String login = cache + "LOGIN:";

    private static final String verityCode = login + "VERITY:";

    private static final String errorNum = login + "ERRORNUM:";

    private static final String lock = login + "LOCK:";

    private static  final String loginflag = cache + "LOGINFLAG:";
    /**
     * @Description 登陆错误次数，五次则死锁
     * @Date  2020/3/25
     **/
    public static String getLoginErrorTimes(String phoneNumber){
        return errorNum + phoneNumber;
    }

    /**
     * @Description 登陆验证码存储
     * @Date  2020/3/25
     **/
    public static String getUserLoginVerityCode(String phoneNumber) {
        return verityCode + phoneNumber;
    }

    /**
     * @Description 用户锁定
     * @Date  2020/3/26
     **/
    public static String getUserLoginLock(String phoneNumber) {
        return lock + phoneNumber;
    }

    /**
     * @Description 用户是否登陆,对应存着用户id
     * @Date  2020/5/12
     **/
    public static String getUserLoginFlag(String sessionId){
        return loginflag + sessionId;
    }

}
