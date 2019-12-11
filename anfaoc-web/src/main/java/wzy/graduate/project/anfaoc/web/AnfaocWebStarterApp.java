package wzy.graduate.project.anfaoc.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description //TODO
 * @author wangzy
 * @Date  2019/12/10
 **/

@EnableDubbo
@SpringBootApplication
public class AnfaocWebStarterApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AnfaocWebStarterApp.class);
        application.run(args);

    }
}
