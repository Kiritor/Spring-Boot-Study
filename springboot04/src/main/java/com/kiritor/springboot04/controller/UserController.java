package com.kiritor.springboot04.controller;

import com.kiritor.springboot04.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static List<User> users = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return users;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(User user) {
        users.add(user);
        return "sucess";
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userName) {
        User result = new User();
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                result = user;
            }
        }
        return result;
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.PUT)
    public String updateUser(User user) {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                u.setPassword(user.getPassword());
            }
        }
        return "success";
    }


    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String userName) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)) {
                index = i;
            }
        }
        if (index != -1) {
            users.remove(index);
        }
        return "success";
    }


}
