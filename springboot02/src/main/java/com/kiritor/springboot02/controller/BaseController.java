package com.kiritor.springboot02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello Springboot";
    }
}
