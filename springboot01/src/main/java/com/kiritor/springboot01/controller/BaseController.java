package com.kiritor.springboot01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/")
    public String hello(){
        return "hello Springboot";
    }

}
