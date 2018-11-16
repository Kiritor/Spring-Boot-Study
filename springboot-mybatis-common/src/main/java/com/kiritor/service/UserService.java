/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserService
 */
package com.kiritor.service;

import com.kiritor.entity.User;

import java.util.List;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/14
 * @since 1.0.0
 */

public interface UserService extends BaseService<User> {
    /**
     * 根据关键字得到用户列表
     * @param username
     * @return
     */
    List<User> getUserListByKey(String username) throws Exception;
}
