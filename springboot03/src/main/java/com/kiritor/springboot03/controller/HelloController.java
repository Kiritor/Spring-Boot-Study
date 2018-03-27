package com.kiritor.springboot03.controller;

import com.kiritor.springboot03.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    User user;
    @RequestMapping("/")
    public String hello(){
        return user.getId()+":"+user.getUserName()+":"+user.getAge()+"||"+user.getDes();
    }

}
