package com.kiritor.controller;

import com.kiritor.entity.User;
import com.kiritor.mapper.UserMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    UserMapper userMapper;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        return userMapper.list();
    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public List<User> findByUserName(@PathVariable String userName){
        return userMapper.findByUserName(userName);
    }


}
