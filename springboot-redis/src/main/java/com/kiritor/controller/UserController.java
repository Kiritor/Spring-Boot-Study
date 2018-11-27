package com.kiritor.controller;

import com.kiritor.entity.User;
import com.kiritor.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserListByKey(@RequestParam String key) throws Exception{
        List<User> list = userService.getUserListByKey(key);
        return list;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id) throws Exception{
        return userService.getUserById(id);
    }
}
