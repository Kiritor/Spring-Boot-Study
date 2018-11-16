package com.kiritor.controller;

import com.kiritor.entity.User;
import com.kiritor.mapper.UserMapper2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    UserMapper2 userMapper2;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        return userMapper2.list();
    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public List<User> findByUserName(@PathVariable String userName){
        return userMapper2.findByUserName(userName);
    }

    @RequestMapping(value = "/getUserListByKey",method = RequestMethod.GET)
    public List<User> getUserListByKey(@RequestParam String key){
        return userMapper2.getUserListByKey(key);
    }


}
