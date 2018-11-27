package com.kiritor.controller;

import com.kiritor.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Map<String,Object>> list() throws Exception {
        return userService.getAllUsers();
    }
}
