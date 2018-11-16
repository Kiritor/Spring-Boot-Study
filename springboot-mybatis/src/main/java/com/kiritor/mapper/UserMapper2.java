package com.kiritor.mapper;

import com.kiritor.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserMapper2 {


    //定义可重复映射集

    @Results(id="user",value={
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "telPhone", column = "TEL-PHONE")
    })
    @Select("select * from t_user where 1=1")
    List<User> list();

    @ResultMap("user")
    @Select("select * from t_user where user_name = #{userName}")
    List<User> findByUserName(String username);

    @Delete("delete from t_user where user_id = #{userId}")
    int delete(String userId);


    /**
     * 模糊搜索(高级注解实现动态SQL)
     * @param key
     * @return
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getUserListByKey")
    List<User> getUserListByKey(@Param("key") String key);

}