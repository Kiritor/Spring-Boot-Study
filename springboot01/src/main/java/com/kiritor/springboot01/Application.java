package com.kiritor.springboot01;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        //TEST
        //SpringApplication.run(Application.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        //修改Banner的模式为OFF
        builder.bannerMode(Banner.Mode.CONSOLE).run(args);
    }
}
