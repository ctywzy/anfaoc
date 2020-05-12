package wzy.graduate.project.anfaoc.web.homepage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;
import wzy.graduate.project.anfaoc.web.cache.RedisKeyConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author wangzy
 */

@Api(tags = "主页相关")
@Controller
@RequestMapping("/")
@Slf4j
public class PageController {

    @Autowired
    private RedisHelper redis;

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
    @GetMapping("homepage")
    public String homePage(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        String loginFlag = (String) redis.getValue(loginKey);
        if(Objects.isNull(loginFlag)){
            return "usercontrol/login";
        }else{
            return "page/userPage";
        }

    }

    @ApiOperation("新闻页面")
    @GetMapping("newsPage")
    public String newsPage(){
        return "page/newsPage";
    }

    @ApiOperation("新闻详情")
    @GetMapping("getNewsDetail/{id}")
    public String getNewsDetail(@PathVariable("id") Long newsId, Model model){
        model.addAttribute("newsId",newsId);
        return "page/newsDetailPage";
    }

    @ApiOperation("收藏新闻")
    @PostMapping("collectNews/{id}")
    public String collectNews(@PathVariable("id") Long newsId,Model model,
                                                  HttpServletRequest request){
        //先判断用户登陆没有
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String loginKey = RedisKeyConstant.getUserLoginFlag(sessionId);
        String loginFlag = (String) redis.getValue(loginKey);

        if(Objects.isNull(loginFlag)){
            return "usercontrol/login";
        }
        // TODO 收藏新闻


        //重新加载页面
        model.addAttribute("newsId",newsId);
        return "page/newsDetailPage";

    }

    @ApiOperation("用户登出")
    @PostMapping(value = "/logout")
    public String userLoginOut(HttpServletRequest request){
        String sessionId = request.getRequestedSessionId();
        String loginFlag = RedisKeyConstant.getUserLoginFlag(sessionId);
        redis.remove(loginFlag);
        return "page/newsPage";
    }
}
