package com.kiritor.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户列表
     */
    List<Map<String,Object>> getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
