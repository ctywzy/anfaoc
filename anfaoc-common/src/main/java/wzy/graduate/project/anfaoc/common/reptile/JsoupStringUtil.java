package wzy.graduate.project.anfaoc.common.reptile;

import org.jsoup.nodes.Element;

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
        return originStr.substring(index+1,length-2);
    }

    /**
     * @Description 从整体的字符串中拆分出新闻的标签
     * @Date  2020/1/16
     **/
    public static List<String> getLabelsFromStr(String orginStr){
        String[] labelsStr = orginStr.split(" ");
        List<String> labels = new ArrayList<>();
        for(String str : labelsStr){
            labels.add(str);
        }
        return labels;
    }

    /**
     * @Description 获取图片地址
     * @Date  2020/1/19
     **/
    public static String getPicsLink(String str) {
        return str.substring(10,str.length()-2);
    }

    /**
     * @Description 从主页的文章标签中获取
     * @Date  2020/1/20
     * @param index href字符串的下标
     **/
    public static String getNewsUrlFromHref(int index, Element element){

        String originUrl = element.toString();
        int finalindex = 0;
        for(int i=index+6 ; i<originUrl.length(); i++){
            if(originUrl.charAt(i)=='"'){
                finalindex = i;
                break;
            }
        }
        return originUrl.substring(index+6,finalindex).trim();
    }
}
