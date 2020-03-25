package wzy.graduate.project.anfaoc.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Description 启动类文件
 * @author wangzy
 * @Date  2019/12/10
 **/

@EnableDubbo
@SpringBootApplication
@Import(AnfaocWebStarterAutoConfig.class)
public class AnfaocWebStarterApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AnfaocWebStarterApp.class);
        application.run(args);

    }
}
