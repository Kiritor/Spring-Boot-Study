package com.kiritor.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello ";
    }
}
