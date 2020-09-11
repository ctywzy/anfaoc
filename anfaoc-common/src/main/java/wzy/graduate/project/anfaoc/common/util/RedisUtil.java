package wzy.graduate.project.anfaoc.common.util;


import com.google.common.collect.Maps;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.extern.slf4j.Slf4j;
import wzy.graduate.project.anfaoc.common.model.ZhenziSMS;

import java.util.Map;
import java.util.Objects;

/**
 * @Description redis操作相关工具
 * @Date  2020/3/25
 * @Author wangzy
 **/

@Slf4j
public class RedisUtil {

    public static final ZhenziSmsClient client = new ZhenziSmsClient(ZhenziSMS.APIURL,ZhenziSMS.APPID,ZhenziSMS.APPSECRET);

    /**
     * @Description 向指定手机号发送验证码
     * @Date  2020/3/25
     **/
    public static void getSendVerityCode(String phoneNumber,Integer verityCode) throws Exception {
        Map<String,String> param = Maps.newHashMap();
        StringBuilder message = new StringBuilder("您好，您的验证码是:" + verityCode);
        param.put("number",phoneNumber);
        param.put("message",message.toString());
        String result = null;
        result = client.send(param);
        log.info("验证码获取请求:{}",result);
    }

    public static int calErrorTimes(Object getLoginErrorTimes) {
        int times = 4;
        if(Objects.nonNull(getLoginErrorTimes)){
            times =( (int) getLoginErrorTimes ) - 1;
        }
        return times;
    }

    public static boolean lockedJudge(Object loginErrorTimes) {
        if(Objects.nonNull(loginErrorTimes)){
            int time = (int) loginErrorTimes;
            if(time == 0){
                return true;
            }
        }
        return false;
    }
}
