package wzy.graduate.project.anfaoc.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wzy.graduate.project.anfaoc.common.interceptor.LoginStatus;

/**
 * @author wangzy
 * @date 2020-01-06
 * @description 添加拦截器，判断登陆状态
 */

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginStatus())
            //拦截所有api
            .addPathPatterns("/**")
            //普通用户相关，无论是否登陆都是可以访问的，将下面路径的api排除在外
            .excludePathPatterns("/api/anfaoc/user/ordinary/**");
    }
}
