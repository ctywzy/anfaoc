package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@RestController
@Api(tags = "用户登陆管理")
@RequestMapping("/api/anfaoc/user")
@Slf4j
public class UserLoginController {

    @Reference
    private UserDetailFacade userDetailFacade;

    @ApiOperation("查看所有用户信息")
    @GetMapping(value = "/login")
    public List<UserDetail> userLogin(){
        return userDetailFacade.getAllUserDetail();
    }

}
