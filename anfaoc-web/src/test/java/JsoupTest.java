import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.common.reptile.JsoupUtil;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunConfig.class)
public class JsoupTest {

    @Test
    public void getNews() {
        String url = "https://ent.ifeng.com/c/7ukOTAI4x4S";
        try{
            NewsDetailDTO newsDetail = JsoupUtil.getNewsDetailEntity(url);
            System.out.println(newsDetail.getNewLabels());
            System.out.println(newsDetail.getNewParas());
            System.out.println(newsDetail.getNewTitle());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
