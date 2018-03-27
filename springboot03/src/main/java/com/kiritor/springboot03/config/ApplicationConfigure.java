package com.kiritor.springboot03.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class ApplicationConfigure implements CommandLineRunner {
    @Value("${app.sysName}")
    private String sysName;
    @Override
    public void run(String... strings) throws Exception {
         //预先加载一些类、图片、属性等
    }
}
