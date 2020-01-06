package wzy.graduate.project.anfaoc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author wangzy
 * @Date 2019-12-31
 */
@EnableWebSecurity
@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//    }

    /** 编码设置 **/
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password(new BCryptPasswordEncoder().encode("password")).roles("USER");
    }

    /** 权限设置 **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //规则配置
                //这条说明普通页面大家都可以访问
                .antMatchers("/api/anfaoc/user/ordinary/**").permitAll()
                .antMatchers("/api/anfaoc/user/admin/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/home")
                .defaultSuccessUrl("/success")
                //这个需和提交表单的action内容一致
                .loginProcessingUrl("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll();
        http.csrf().disable();
    }

    /** 某些网页不拦截 **/
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//            //这个配置是忽略某些api不进行验证么
//            .ignoring()
//            .antMatchers("/api/anfaoc/user/ordinary/**");
//    }
}
