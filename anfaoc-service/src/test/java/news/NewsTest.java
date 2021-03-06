package news;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;
import wzy.graduate.project.anfaoc.service.AnfaocServiceStarterApp;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnfaocServiceStarterApp.class)
public class NewsTest {

    @Autowired
    private LabelDetailFacade labelDetailFacade;

    @Autowired
    private NewsDetailFacade newsDetailFacade;

    @Test
    public void getNewsPage(){
        NewsPagingRequest request = new NewsPagingRequest();
        request.setPagingNo(1);
        newsDetailFacade.newsPage(request);
    }

    /**
     * @Description 测试从新闻主页抓取的数据
     * @Date  2020/3/11
     * @Param
     * @return
     **/
    @Test
    public void updateNewsTest(){
        List<NewsDetailDTO> newslist = JsoupUtil.updateNewsLibrary();
        newslist = newslist.subList(1,2);
        //存储或更新标签，规则是出现一次就+2，第一次出现为0
        labelDetailFacade.updateLabelDetail(newslist);

        //存储新闻
        newsDetailFacade.updateNews(newslist);
        System.out.println(newslist.size());
    }

    @Test
    public void insertLabel(){
        String url = "https://fo.ifeng.com/c/7uxYlNvcACG";
        try{
            NewsDetailDTO newsDetail = JsoupUtil.getNewsDetailEntity(url);
            List<NewsDetailDTO> list = Lists.newArrayList();
            list.add(newsDetail);
            //labelDetailFacade.updateLabelDetail(list);
            newsDetailFacade.updateNews(list);
            System.out.println(list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
