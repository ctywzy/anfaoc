package wzy.graduate.project.anfaoc.common.reptile;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wzy.graduate.project.anfaoc.common.enums.ParaType;
import wzy.graduate.project.anfaoc.common.model.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wangzy
 */

public class JsoupUtil {

    private static final String homePageUrl = "http://www.ifeng.com/";

    /**
     * @Description 根据一条url保存下一篇新闻相关的内容
     * @Date  2020/1/17
     * @Param
     * @return
     **/
    public static NewsDetail getNewsDetailEntity(String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();
        NewsDetail newsDetail = NewsDetail.builder()
                .title(getTitle(doc))
                .labels(getLabels(doc))
                .paras(getParas(doc)).build();

        return newsDetail;
    }


    /**
     * @Description 获取标题的方法
     * @note 字符串处理是否需要进行异常相关的处理
     * @Date  2020/1/16
     **/
    private static String getTitle(Document doc){
        Elements element = doc.getElementsByTag("meta");
        Element elementTitle = Optional.ofNullable(element.select("meta[property~=og:title]"))
                .orElseGet(Elements::new).stream().findAny().orElse(null);
        return JsoupStringUtil.getContentFromContent(elementTitle.toString());
    }

    /**
     * @Description 获取标签的方法
     * @Date  2020/1/16
     **/
    private static List<String> getLabels(Document doc){
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
    private static List<ParaEntity> getParas(Document doc){
        Elements elements = doc.getElementsByClass("text-3zQ3cZD4");
        Elements originElements = elements.select("div").select("p");
        List<ParaEntity> paras = new ArrayList<>();
        String str = null;
        for(int i = 0; i<originElements.size(); i++){
            Element element = originElements.get(i);
            str = element.toString().trim();
            if(str.contains("detailPic")){
                paras.add(new ParaEntity(
                    ParaType.PICTURE,JsoupStringUtil.getPicsLink(element.html())
                ));
            }else if(str.contains("picIntro")){
                paras.add(new ParaEntity(
                    ParaType.DESCRIPTION,element.html()
                ));
            }else{
                paras.add(new ParaEntity(
                    ParaType.PARAGRAPH,element.html()
                ));
            }
        }
        return paras;
    }

    /**
     * @Description 定时任务中用来更新新闻库的方法
     * @Date  2020/1/20
     **/
    public static List<String> updateNewsLibrary() {
        Connection conn = Jsoup.connect(homePageUrl);
        List<String> urlList = new ArrayList<>();
        try{
            Document doc = conn.get();
            urlList = getHomePageNewsUrl(doc);
        } catch (IOException e){
            e.printStackTrace();
        }
        return urlList;
    }

    /**
     * @Description 根据主页地址来获取所有的url
     * @Date  2020/1/20
     **/
    private static List<String> getHomePageNewsUrl(Document doc) {
        Elements elements = doc.getElementsByTag("a");
        List<String> urlList = new ArrayList<>();
        for(Element element : elements){
            String str = element.toString();
            if(str.contains("/c/7")){
                int index = str.indexOf("href");
                urlList.add(JsoupStringUtil.getNewsUrlFromHref(index,element));
            }
        }
        return urlList;
    }
}
