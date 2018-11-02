package com.kiritor.springboot03.controller;

import com.kiritor.springboot03.domain.NewUser;
import com.kiritor.springboot03.domain.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableConfigurationProperties({NewUser.class, Test.class})
public class NewUserController {
    @Resource
    NewUser newUser;

    @RequestMapping("/newuser")
    public String hello() {
        return newUser.getId() + ":" + newUser.getUserName() + ":" + newUser.getAge() + "||" + newUser.getDes();
    }

    @Resource
    Test test;

    @RequestMapping("/test")
    public String test() {
        return test.getUserName() + ":" + test.getAge();
    }

}
