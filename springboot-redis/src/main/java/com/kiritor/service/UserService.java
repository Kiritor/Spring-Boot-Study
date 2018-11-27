package com.kiritor.service;

import com.kiritor.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 得到用户列表
     * @param key
     * @return
     */
    List<User> getUserList() throws Exception;

    /**
     * 根据关键字得到用户列表
     * @param key
     * @return
     */
    List<User> getUserListByKey(String key) throws Exception;


    /**
     * 根据id得到用户
     */

    User getUserById(Integer id) throws Exception;

    /**
     * 更新用户
     * @param user
     * @return
     * @throws Exception
     */
    User updateUser(User user) throws Exception;

}
