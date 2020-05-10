package wzy.graduate.project.anfaoc.web.homepage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.common.model.Response;

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

    @ApiOperation("成功")
    @GetMapping("login")
    public String loginPage(){
        return "usercontrol/index";
    }

    @ApiOperation("登陆页面")
    @GetMapping("homepage")
    public String homePage(){
        return "page/homePage";
    }
}
