/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserController
 */
package com.kiritor.controller;

import com.kiritor.entity.User;
import com.kiritor.repository.UserRepository;
import com.kiritor.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/16
 * @since 1.0.0
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    UserRepository userRepository;
    @Resource
    UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Map<String,Object> getUserList(Integer pageNum, Integer pageSize) throws Exception{
        Map<String,Object> result = new HashMap<>();
        List<User> list = userRepository.findAll();
        Page<User> page = userService.find(1,2);
        result.put("total",list.size());
        result.put("rows",list);
        return result;
    }


    @RequestMapping(value = "/getUserListByName",method = RequestMethod.GET)
    public Map<String,Object> getUserList(@RequestParam String userName) throws Exception{
        Map<String,Object> result = new HashMap<>();
        List<User> list = userRepository.finByUserName(userName);
        result.put("total",list.size());
        result.put("rows",list);
        return result;
    }

}
