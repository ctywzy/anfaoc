package wzy.graduate.project.anfaoc.web.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;
import wzy.graduate.project.anfaoc.api.facade.UserDetailFacade;
import wzy.graduate.project.anfaoc.common.exception.RestException;
import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.ZhenziSMS;
import wzy.graduate.project.anfaoc.web.context.UserContext;

import java.util.List;

/**
 * @author wangzy
 */

@RestController
@Api(tags = "用户信息管理--管理员")
@Slf4j
@RequestMapping("/api/anfaoc/user/admin")
public class AdminController {

    @Reference
    private UserDetailFacade userDetailFacade;

    @ApiOperation("管理员-查看所有用户信息")
    @GetMapping(value = "/getAllUser")
    public List<UserDetail> getAllUser(){
        Response<List<UserDetail>> response = userDetailFacade.getAllUserDetail();
        UserContext.setUserLocal(response.getResult().get(0));
        log.info("线程名:{}",Thread.currentThread().getId());
        return response.getResult();
    }

    @ApiOperation("管理员-获取剩余可用短信额度")
    @GetMapping(value = "/remainingSMSCredit")
    public String remainingSMSCredit()  {
        ZhenziSmsClient client = new ZhenziSmsClient(ZhenziSMS.APIURL,ZhenziSMS.APPID,ZhenziSMS.APPSECRET);
        String remaining = new String();
        try{
            remaining = client.balance();
        }catch (Exception e){
            throw  new RestException(e.getMessage());
        }
        log.info("=======》剩余短信条数信息:{}",remaining);
        return remaining;
    }
}
