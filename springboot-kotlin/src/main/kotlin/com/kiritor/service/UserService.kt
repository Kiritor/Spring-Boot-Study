package com.kiritor.service

import com.kiritor.entity.User

interface UserService {
    fun getUserList():List<User>
    /**
     * 根据关键字获取用户列表
     */
    fun getUserByKey(key:String):List<User>
}