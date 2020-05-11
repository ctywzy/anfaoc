package wzy.graduate.project.anfaoc.web.homepage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.NewsDetailDTO;

/**
 * @author wangzy
 */

@Api(tags = "主页相关")
@Controller
@RequestMapping("/")
@Slf4j
public class PageController {

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
        return "usercontrol/index";
    }

    @ApiOperation("用户信息页面")
    @GetMapping("homepage")
    public String homePage(){
        return "page/userPage";
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
        return "/page/newDetailPage";
    }
}
