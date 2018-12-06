package com.kiritor.controller

import com.kiritor.entity.User
import com.kiritor.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/users")
class UserController {

    @Autowired
    lateinit var userService : UserService


    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun index(): List<User> {
        return userService.getUserList()
    }

    @RequestMapping(value = "/getUserListByKey", method = arrayOf(RequestMethod.GET))
    fun getUserListByKey(@RequestParam("key")key:String): List<User> {
        return userService.getUserByKey(key)
    }
}