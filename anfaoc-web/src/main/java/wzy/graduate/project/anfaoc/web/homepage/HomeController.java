package wzy.graduate.project.anfaoc.web.homepage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author terminus
 */

@Api(tags = "主页相关")
@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    @ApiOperation("主页显示")
    @GetMapping("home")
    public String homePage(){
        return "homepage";
    }

    @ApiOperation("成功")
    @GetMapping("homepage")
    public String successPage(){
        return "index";
    }
}
