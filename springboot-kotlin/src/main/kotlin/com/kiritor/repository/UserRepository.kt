package com.kiritor.repository

import com.kiritor.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.io.Serializable


interface UserRepository: JpaRepository<User, Long>,
        Serializable {

    @Query("from User t where t.userName like %:key% or t.telPhone like %:key%")
    fun getUserByKey(@Param("key")key:String):List<User>

}