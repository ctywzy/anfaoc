package wzy.graduate.project.anfaoc.web.news;


import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.Request.NewsPagingRequest;
import wzy.graduate.project.anfaoc.api.domain.dto.CommentsDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.LabelDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.NewsDetail;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.facade.CommentsFacade;
import wzy.graduate.project.anfaoc.api.facade.LabelDetailFacade;
import wzy.graduate.project.anfaoc.api.facade.NewsDetailFacade;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.web.cache.RedisKeyConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@Api(tags = "新闻管理")
@RequestMapping("api/anfaoc/news")
public class newsDetailController {

    @Reference
    private NewsDetailFacade newsDetailFacade;

    @Reference
    private UserDetailFacade userDetailFacade;

    @Reference
    private CommentsFacade commentsFacade;

    @Reference
    private LabelDetailFacade labelDetailFacade;

    @Autowired
    private RedisHelper redis;

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

    @ApiOperation("推荐新闻获取")
    @GetMapping("getRecommentNews")
    public Response<List<NewsDetailDTO>> getRecNews(Integer pageNo){
        NewsPagingRequest request = new NewsPagingRequest();
        request.setPagingNo(pageNo);
        Response<List<NewsDetailDTO>> response = newsDetailFacade.newsPageRecommend(request);
        if(response.isSuccess()){
            return Response.ok(response.getResult());
        }else{
            return Response.fail("获取新闻失败");
        }
    }

    @ApiOperation("用户收藏新闻获取")
    @GetMapping("/getColNews")
    public Response<List<NewsDetailDTO>> getColNews(String userId){
        Response<List<NewsDetailDTO>> response = newsDetailFacade.newsColPage(userId);
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

    @ApiOperation("新闻评论")
    @PostMapping("newsComment")
    public Response<String> newsComment(@RequestBody CommentsDTO commentsDTO, HttpServletRequest request){

        //先判断用户登陆没有
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return Response.fail("未登陆");
        }

        if(stringCheck(commentsDTO.getContent()) || stringCheck(commentsDTO.getNewsId())){
            return Response.fail("参数为空");
        }
        Response<UserDetail> userDetailResponse = userDetailFacade.findUserByUserId(String.valueOf(userId));
        String username = userDetailResponse.getResult().getUserName();
        commentsDTO.setUsername(username);
        commentsFacade.addComment(commentsDTO);
        return Response.ok(commentsDTO.getNewsId());

    }

    @ApiOperation("获取所有标签")
    @GetMapping("/getAllLabel")
    public Response<List<LabelDetail>> getAllLabel(Integer pageNo){
        NewsPagingRequest request = new NewsPagingRequest();
        request.setPagingNo(pageNo);
        Response<List<LabelDetail>> response = labelDetailFacade.getAllLabel(request);
        return response;
    }

    @ApiOperation("获取用户下的所有标签")
    @GetMapping("/getAllUserLabel")
    public Response<List<LabelDetail>> getAllUserLabel(Integer pageNo,HttpServletRequest httpRequest){
        NewsPagingRequest request = new NewsPagingRequest();
        request.setPagingNo(pageNo);
        HttpSession session = httpRequest.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);
        request.setUserId(String.valueOf(userId));
        Response<List<LabelDetail>> response = labelDetailFacade.getAllLabel(request);
        return response;
    }

    /**
     * @Description 参数校验
     * @Date  2020/5/13
     **/
    private boolean stringCheck(String  str){
        if(Objects.isNull(str)){
            return true;
        }
        if(str.length() == 0){
            return true;
        }
        return false;
    }


}
