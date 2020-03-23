package news;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsTest.class)
public class NewsTest {

    @Reference
    private LabelDetailFacade labelDetailFacade;

    @Reference
    private NewsDetailFacade newsDetailFacade;

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
}
