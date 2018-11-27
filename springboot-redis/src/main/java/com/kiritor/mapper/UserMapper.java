package com.kiritor.mapper;


import com.kiritor.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据关键字得到用户列表
     * @param key
     * @return
     */
    List<User> getUserListByKey(String key);
}