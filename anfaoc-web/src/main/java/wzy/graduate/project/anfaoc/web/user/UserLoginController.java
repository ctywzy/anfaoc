package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wzy.graduate.project.anfaoc.api.domain.dto.UserDetailDTO;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.redis.RedisHelper;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.web.context.UserContext;

/**
 * @Description 用户管理信息Controller
 * @author wangzy
 * @Date  2019/12/10
 **/

@RestController
@Api(tags = "用户信息管理")
@RequestMapping("/api/anfaoc/user")
@Slf4j
public class UserLoginController {

    @Reference
    private UserDetailFacade userDetailFacade;

    @Autowired
    private RedisHelper redisHelper;

    @ApiOperation("ThreadLocal效果查看")
    @GetMapping("/getUserLocal")
    public UserDetail getUserLocal(){
        log.info("线程名:{}",Thread.currentThread().getId());

        return UserContext.getUserLocal();
    }

}
