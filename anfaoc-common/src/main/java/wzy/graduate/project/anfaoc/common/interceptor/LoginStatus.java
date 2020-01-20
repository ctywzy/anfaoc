package wzy.graduate.project.anfaoc.common.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wangzy
 * @date 2020-01-06
 * @description 登陆状态判断拦截器
 */

@Slf4j
public class LoginStatus implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("=====>登陆状态判断拦截器");
        HttpSession session = request.getSession();
        log.info("=====>sessionId是{}",session.getId());
        //根据sessionId若可以获取redis中的用户信息，则为登陆状态

        //否则说明未登陆或者已过期
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
