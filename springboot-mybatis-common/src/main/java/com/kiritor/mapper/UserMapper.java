package com.kiritor.mapper;


import com.kiritor.entity.User;
import com.kiritor.utils.CommonMapper;

import java.util.List;

public interface UserMapper extends CommonMapper<User> {
    /**
     * 根据关键字得到用户列表
     * @param key
     * @return
     */
    List<User> getUserListByKey(String key);
}