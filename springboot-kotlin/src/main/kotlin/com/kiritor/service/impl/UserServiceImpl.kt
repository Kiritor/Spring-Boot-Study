package com.kiritor.service.impl

import com.kiritor.entity.User
import com.kiritor.repository.UserRepository
import com.kiritor.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl:UserService{

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUserList(): List<User> {
        return userRepository.findAll()
    }

    override fun getUserByKey(key:String): List<User> {
        return userRepository.getUserByKey(key)
    }

}