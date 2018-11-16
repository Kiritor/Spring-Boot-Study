package com.kiritor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动类
 * @Author Kiritor
 * @Date  2018/11/15
 */

@SpringBootApplication
@MapperScan("com.kiritor.mapper")
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MybatisApplication.class);
        builder.run(args);
    }

}
