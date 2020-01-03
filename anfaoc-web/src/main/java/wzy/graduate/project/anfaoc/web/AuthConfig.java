package wzy.graduate.project.anfaoc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
                .antMatchers("/api/anfaoc/user/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/home")
                .permitAll()
            .and()
                .logout()
                .permitAll();
        http.csrf().disable();
    }
}
