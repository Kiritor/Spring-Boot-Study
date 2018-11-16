/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserServiceImpl
 */
package com.kiritor.service.impl;

import com.kiritor.entity.User;
import com.kiritor.mapper.UserMapper;
import com.kiritor.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/14
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public List<User> getUserListByKey(String key) throws Exception{
        return userMapper.getUserListByKey(key);
    }
}
