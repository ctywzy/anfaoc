package wzy.graduate.project.anfaoc.common.reptile;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wzy.graduate.project.anfaoc.common.enums.ParaType;
import wzy.graduate.project.anfaoc.common.exception.ServiceException;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wangzy
 */

@Slf4j
public class JsoupUtil {

    private static final String homePageUrl = "http://www.ifeng.com/";

    /**
     * @Description 根据一条url保存下一篇新闻相关的内容
     * @Date  2020/1/17
     * @Param
     * @return
     **/
    public static NewsDetailDTO getNewsDetailEntity(String url) {
        
        Connection conn = Jsoup.connect(url);
        Document doc = null;
        try{
            doc = conn.get();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(doc.title().contains("404-页面不存在")){
            throw new ServiceException("404-页面不存在");
        }
        NewsDetailDTO newsDetailDTO = NewsDetailDTO.builder()
                .title(getTitle(doc))
                .labels(getLabels(doc))
                .paras(getParas(doc)).build();

        return newsDetailDTO;
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
                if(element.html().length()>12){
                    paras.add(new ParaEntity(
                            ParaType.PICTURE,JsoupStringUtil.getPicsLink(element.html())
                    ));
                }
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
     * @Description 定时任务中用来更新新闻库的方法,这个方法用来爬取首页的所有合适的新闻
     * @Date  2020/1/20
     **/
    public static List<NewsDetailDTO> updateNewsLibrary() {
        Connection conn = Jsoup.connect(homePageUrl);
        List<NewsDetailDTO> newsList = new ArrayList<>();
        List<String> urlList = null;
        try{
            Document doc = conn.get();
            urlList = getHomePageNewsUrl(doc);
        } catch (Exception e){
            e.printStackTrace();
        }
        for(String url : urlList){
            System.out.println(url);
            try{
                newsList.add(getNewsDetailEntity(url));
            }catch (Exception e){
                log.error("===>页面不存在,错误的url地址:{}",url);
            }

        }
        return newsList;
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
                String url = JsoupStringUtil.getNewsUrlFromHref(index,element);
                if(url.contains("//feng") || url.contains("v.ifeng.")
                    || url.contains("auto.ifeng")){
                    continue;
                }else{
                    if(!url.contains("https:")){
                        url = "https:" + url;
                    }
                    urlList.add(url);
                }
            }
        }
        return urlList;
    }
}
