package wzy.graduate.project.anfaoc.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangzy
 * @Description 日期相关工具
 * @Date  2020/3/23
 **/

public class DateUtil {

    /**
     * @Description 获取规定格式下的当前时间
     * @Date  2020/3/23
     **/
    public static String getNowData(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d hh:mm:ss");
        String nowDate = sdf.format(date);
        return nowDate;
    }

}
