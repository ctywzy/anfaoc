package wzy.graduate.project.anfaoc.web.news;


import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

import java.util.List;

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

    @ApiOperation("热点新闻获取")
    @GetMapping("/getHotNews")
    public Response<List<NewsDetailDTO>> getHotNews(Integer pageNo){
        NewsPagingRequest request = new NewsPagingRequest();
        request.setPagingNo(pageNo);
        Response<List<NewsDetailDTO>> response = newsDetailFacade.newsPage(request);
        if(response.isSuccess()){
            return Response.ok(response.getResult());
        }else{
            return Response.fail("获取新闻失败");
        }
    }

    @ApiOperation("新闻详情")
    @GetMapping("/getNewsDetail")
    public Response<NewsDetailDTO> getNewsDetail(Long newsId){

        Response<NewsDetailDTO> response = newsDetailFacade.getNewsDetail(newsId);

        return response;
    }

}
