package com.kiritor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.Cacheable;

@SpringBootApplication
@MapperScan("com.kiritor.mapper")
@Cacheable
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(RedisApplication.class);
        builder.run(args);
    }
}
