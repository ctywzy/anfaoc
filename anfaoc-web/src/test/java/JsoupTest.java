import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzy.graduate.project.anfaoc.common.model.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.entity.ParaEntity;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunConfig.class)
public class JsoupTest {

    @Test
    public void getNews() {
        String url = "https://news.ifeng.com/c/7tKqDXucgf2";
        try{
            NewsDetail newsDetail = JsoupUtil.getNewsDetailEntity(url);
            System.out.println(newsDetail.getLabels());
            System.out.println(newsDetail.getParas());
            System.out.println(newsDetail.getTitle());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
