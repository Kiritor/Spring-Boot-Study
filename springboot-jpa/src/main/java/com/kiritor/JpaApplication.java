package com.kiritor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动类
 * @Author Kiritor
 * @Date  2018/11/15
 */

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JpaApplication.class);
        builder.run(args);
    }

}
