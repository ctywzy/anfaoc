package wzy.graduate.project.anfaoc.web.homepage;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.domain.dto.CommentsDTO;
import wzy.graduate.project.anfaoc.api.domain.dto.NewsCollectionDTO;
import wzy.graduate.project.anfaoc.api.domain.dto.UserLabelDTO;
import wzy.graduate.project.anfaoc.api.domain.entity.UserLabel;
import wzy.graduate.project.anfaoc.api.facade.NewsCollectionFacade;
import wzy.graduate.project.anfaoc.api.facade.UserLabelFacade;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.web.cache.RedisKeyConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @description 路由信息
 * @author wangzy
 */

@Api(tags = "主页相关")
@Controller
@RequestMapping("/")
@Slf4j
public class PageController {

    @Autowired
    private RedisHelper redis;

    @Reference
    private NewsCollectionFacade newsCollectionFacade;

    @Reference
    private UserLabelFacade userLabelFacade;

    @ApiOperation("主页显示")
    @GetMapping("loginCheck")
    @ResponseBody
    public Response<Boolean> loginCheck(String name){

        System.out.println(name);
        if(name.equals("user")){
            return Response.ok();
        }
        else{
            return Response.fail("错误");
        }
    }

    @ApiOperation("登陆界面")
    @GetMapping("login")
    public String loginPage(){
        return "usercontrol/login";
    }

    @ApiOperation("用户信息页面")
    @GetMapping("homePage")
    public String homePage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Object loginFlag =  redis.getValue(loginKey);

        if(Objects.isNull(loginFlag)){
            return "usercontrol/login";
        }else{
            model.addAttribute("userId",String.valueOf(loginFlag));
            return "page/userPage";
        }

    }

    @ApiOperation("新闻页面")
    @GetMapping("newsPage")
    public String newsPage(){
        return "page/newsPage";
    }

    @ApiOperation("用户标签页面")
    @GetMapping("userLabelPage")
    public String userLabelPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Object loginFlag =  redis.getValue(loginKey);

        if(Objects.isNull(loginFlag)){
            return "usercontrol/login";
        }else{
            return "page/userLabelPage";
        }
    }

    @ApiOperation("新闻详情")
    @GetMapping("getNewsDetail/{id}")
    public String getNewsDetail(@PathVariable("id") Long newsId, Model model){
        model.addAttribute("newsId",newsId);
        return "page/newsDetailPage";
    }

    @ApiOperation("收藏新闻")
    @GetMapping("collectNews/{id}")
    public String collectNews(@PathVariable("id") Long newsId,Model model,
                                                  HttpServletRequest request){
        //先判断用户登陆没有
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return "usercontrol/login";
        }
        NewsCollectionDTO collectionDTO = new NewsCollectionDTO();
        collectionDTO.setNewsId(newsId.toString());
        collectionDTO.setUserId(String.valueOf(userId));
        newsCollectionFacade.addNewsCollection(collectionDTO);

        //重新加载页面
        model.addAttribute("newsId",newsId);
        return "page/newsDetailPage";

    }

    @ApiOperation("用户登出")
    @GetMapping(value = "/logout")
    public String userLoginOut(HttpServletRequest request){
        String sessionId = request.getRequestedSessionId();
        String loginFlag = RedisKeyConstant.getUserLoginFlag(sessionId);
        redis.remove(loginFlag);
        return "page/newsPage";
    }

    @ApiOperation("用户注册")
    @GetMapping(value = "register")
    public String userRegister(){
        return "usercontrol/register";
    }

    @ApiOperation("推荐新闻")
    @GetMapping(value = "newsRecommendPage")
    public String newsRecommendPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return "usercontrol/login";
        }
        return "page/newsRecommendPage";
    }

    @ApiOperation("标签页面")
    @GetMapping(value = "labelPage")
    public String labelPage(String pageNo){
        return "page/labelPage";
    }

    @ApiOperation("添加标签关系")
    @GetMapping("/addLabel/{id}")
    public String addLabel(@PathVariable("id") String LabelId,HttpServletRequest request){
        //先判断用户登陆没有
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return "usercontrol/login";
        }
        UserLabelDTO userLabelDTO = new UserLabelDTO();
        userLabelDTO.setUserId(String.valueOf(userId));
        userLabelDTO.setLabelId(LabelId);
        userLabelFacade.create(userLabelDTO);
        return "page/labelPage";
    }

    @ApiOperation("删除标签关系")
    @GetMapping("/deleteLabel/{id}")
    public String deleteLabel(@PathVariable("id") String LabelId,HttpServletRequest request){
        //先判断用户登陆没有
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return "usercontrol/login";
        }
        UserLabelDTO userLabelDTO = new UserLabelDTO();
        userLabelDTO.setUserId(String.valueOf(userId));
        userLabelDTO.setLabelId(LabelId);
        userLabelFacade.deleteLabel(userLabelDTO);
        return "page/userlabelPage";
    }

    @ApiOperation("用户标签列表")
    @GetMapping("colLabelPage")
    String colLabelPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        Integer userId = (Integer) redis.getValue(loginKey);

        if(Objects.isNull(userId)){
            return "usercontrol/login";
        }
        return "page/userLabelPage";
    }
}
