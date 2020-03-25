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

    private static final String Lock = login + "LOCK:";


    public static String getUserLoginVerityCode(String phoneNumber) {
        return verityCode + phoneNumber;
    }

}
