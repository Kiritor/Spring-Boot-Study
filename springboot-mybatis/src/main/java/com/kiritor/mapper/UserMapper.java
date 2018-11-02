package com.kiritor.mapper;

import com.kiritor.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "telPhone", column = "TEL-PHONE")
    })

    @Select("select * from t_user where 1=1")
    List<User> list();

    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "telPhone", column = "TEL-PHONE")
    })
    @Select("select * from t_user where user_name = #{userName}")
    List<User> findByUserName(String username);

    @Select("select * from t_user where user_id = #{userId}")
    User getOne(String userId);

    @Delete("delete from t_user where user_id = #{userId}")
    int delete(String userId);

}