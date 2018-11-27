package com.kiritor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动类
 * @Author Kiritor
 * @Date  2018/11/15
 */

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(WebApplication.class);
        builder.run(args);
    }

}
