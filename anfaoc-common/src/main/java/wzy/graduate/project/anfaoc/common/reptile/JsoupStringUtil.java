package wzy.graduate.project.anfaoc.common.reptile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author terminus
 */
public class JsoupStringUtil {

    /**
     * 从meta标签的content属性中获取内容
     * @return
     */
    public static String getContentFromContent(String originStr){
        int length = originStr.length();
        int index = 0;
        for(int i = length - 3; i >= 0; i--){
            if(originStr.charAt(i)=='\"'){
                index = i;
                break;
            }
        }
        return originStr.substring(index,length-3);
    }

    /**
     * @Description 从整体的字符串中拆分出新闻的标签
     * @Date  2020/1/16
     **/
    public static List<String> getLablesFromStr(String orginStr){
        String[] lablesStr = orginStr.split(" ");
        List<String> labels = new ArrayList<>();
        for(String str : lablesStr){
            labels.add(str);
        }
        return labels;
    }
}
