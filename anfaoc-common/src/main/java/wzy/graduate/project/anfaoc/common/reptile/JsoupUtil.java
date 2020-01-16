package wzy.graduate.project.anfaoc.common.reptile;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wzy.graduate.project.anfaoc.common.enums.ParaType;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wangzy
 */

public class JsoupUtil {
    public static final String Url = "https://www.huanqiu.com/";
    public static final Connection conn;

    static {
        conn = Jsoup.connect(Url);
    }
    /**
     * @Description 获取标题的方法
     * @note 字符串处理是否需要进行异常相关的处理
     * @Date  2020/1/16
     **/
    public String getTitle(Document doc){
        Elements element = doc.getElementsByTag("meta");
        Element elementTitle = Optional.ofNullable(element.select("meta[property~=og:title]"))
                .orElseGet(Elements::new).stream().findAny().orElse(null);
        return JsoupStringUtil.getContentFromContent(elementTitle.toString());
    }

    /**
     * @Description 获取标签的方法
     * @Date  2020/1/16
     **/
    public List<String> getLabels(Document doc){
        Elements element1 = doc.getElementsByTag("meta");
        Element lables = Optional.ofNullable(element1.select("meta[name~=keywords]"))
                .orElseGet(Elements::new).stream().findAny().orElse(null);
        String originLabel = JsoupStringUtil.getContentFromContent(lables.toString());
        List<String> labels = JsoupStringUtil.getLablesFromStr(originLabel);
        return labels;
    }

    /**
     * @Description 获取文章内容
     * @Date  2020/1/16
     **/
    public List<ParaEntity> getContent(Document doc){
        Elements elements = doc.getElementsByClass("text-3zQ3cZD4");
        Elements originElements = elements.select("div").select("p");
        List<ParaEntity> paras = new ArrayList<>();
        ParaEntity para = new ParaEntity();
        for(int i = 0;i<originElements.size();i++){
            String str = originElements.get(i).toString();
            if(str.charAt(0)=='<' && str.charAt(1)=='i'
                && str.charAt(2)=='m'){
                para.setType(ParaType.PICTURE);
                para.setContent(str);
                str = originElements.get(++i).toString();
                paras.add(para);
                para.setType(ParaType.DESCRIPTION);
                para.setContent(str);
                paras.add(para);

            }else{
                para.setType(ParaType.PARAGRAPH);
                para.setContent(str);
                paras.add(para);
            }
        }
        return paras;
    }

}
