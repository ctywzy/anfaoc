package wzy.graduate.project.anfaoc.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDubbo //dubbo支持
@SpringBootApplication
@EnableScheduling //定时任务支持
@Import(AnfaocServiceStarterAutoConfig.class)
public class AnfaocServiceStarterApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AnfaocServiceStarterApp.class);
        application.run(args);
    }
}
