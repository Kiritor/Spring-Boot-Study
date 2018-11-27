package com.kiritor.service.impl;

import com.kiritor.entity.User;
import com.kiritor.mapper.UserMapper;
import com.kiritor.service.UserService;
import com.kiritor.uitls.GeneralBeanOrMapUtils;
import com.kiritor.uitls.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<User> getUserListByKey(String key) throws Exception{
        return userMapper.getUserListByKey(key);
    }


    @Override
    public List<User> getUserList() throws Exception {
        return null;
    }

    @Override
    public User updateUser(User user) throws Exception {
        //更新数据库
        userMapper.updateByPrimaryKeySelective(user);
        //缓存失效
        redisUtil.delete("user_"+user.getId());

        return user;
    }

    @Override
    public User getUserById(Integer id) throws Exception {
        User user = null;

         //* Cache Aside策略
         //*
         //* 失效：应用程序先从cache取数据，没有得到，则从数据库中取数据，成功后，放到缓存中。
         //* 命中：应用程序从cache中取数据，取到后返回。
         //* 更新：先把数据存到数据库中，成功后，再让缓存失效。

        String user_key = "user_" + id;
        boolean hasKey = redisUtil.hasKey(user_key);
        if(hasKey){
            // 缓存存在
            user = GeneralBeanOrMapUtils.convertMap2Bean(User.class, (Map) redisUtil.get(user_key)) ;
            logger.info("从缓存获取对象:"+user.toString());
        }
        // 缓存不存在,数据库获取信息
        user = userMapper.selectByPrimaryKey(id);
        redisUtil.set(user_key,user);
        logger.info("插入缓存对象:" + user.toString());
        return user;
    }



    /*
    @Override
    @Cacheable(value="users", key = "#id")
    public User getUserById(Integer id) throws Exception {

        // * Cache Aside策略
        // *
        // * 失效：应用程序先从cache取数据，没有得到，则从数据库中取数据，成功后，放到缓存中。
        // * 命中：应用程序从cache中取数据，取到后返回。
        // * 更新：先把数据存到数据库中，成功后，再让缓存失效。

        long beginTime=System.currentTimeMillis();
        User user = userMapper.selectByPrimaryKey(id);
        long time= System.currentTimeMillis()-beginTime;
        logger.info("查询缓存对象:" + user.toString());
        logger.info("时间:" + time);
        return user;
    }
    */

}
