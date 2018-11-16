package com.kiritor.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kiritor.entity.City;
import com.kiritor.entity.User;
import com.kiritor.service.CityService;
import com.kiritor.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    CityService cityService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Map<String,Object> getUserList(Integer pageNum, Integer pageSize) throws Exception{
        Map<String,Object> result = new HashMap<>();
        Page page =PageHelper.startPage(pageNum, pageSize,true);
        List<User> userList = userService.getObjList();
        result.put("total",page.getTotal());
        result.put("rows",userList);
        return result;
    }
    @RequestMapping(value = "/{key}",method = RequestMethod.GET)
    public Map<String,Object> getUserListByKey(@PathVariable String key,Integer pageNum, Integer pageSize) throws Exception{
        Map<String,Object> result = new HashMap<>();
        Page page =PageHelper.startPage(pageNum, pageSize,true);
        List<User> userList = userService.getUserListByKey(key);
        City city = cityService.getCityById(1);
        result.put("total",page.getTotal());
        result.put("rows",userList);
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String  deleteUserById(@PathVariable Integer id) throws Exception{
        userService.delete(id);
        return "success";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public User  addUser(User user) throws Exception{
        return  userService.save(user);
    }

}
