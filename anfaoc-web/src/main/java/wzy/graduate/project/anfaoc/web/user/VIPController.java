package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;

/**
 * @author wangzy
 */

@Api(tags = "用户信息管理--vip用户")
@RestController
@RequestMapping("/api/anfaoc/user/VIP")
@Slf4j
public class VIPController {

    @Reference
    private UserDetailFacade userDetailFacade;


}
