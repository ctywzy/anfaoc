package wzy.graduate.project.anfaoc.web.news;


import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;

@RestController
@Slf4j
@Api(tags = "新闻管理")
@RequestMapping("api/anfaoc/news")
public class newsDetailController {

    @Reference
    private NewsDetailFacade newsDetailFacade;

    @ApiOperation("更新新闻")
    @GetMapping("/updateNews")
    public void updateNews(){

    }

}
