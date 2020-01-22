package news;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsTest.class)
public class NewsTest {

    @Test
    public void updateNewsTest(){
        List<NewsDetailDTO> newslist = JsoupUtil.updateNewsLibrary();
        for(int i=1;i<=10;i++){
            System.out.println("10");
        }
        System.out.println(newslist.size());
    }
}
