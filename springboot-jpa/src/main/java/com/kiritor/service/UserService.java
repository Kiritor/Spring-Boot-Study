/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserService
 */
package com.kiritor.service;

import com.kiritor.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/16
 * @since 1.0.0
 */

public interface UserService {
    /**
     * 保存用户信息
     *
     * @param user
     *            用户信息对象
     * @return 保存成功后的用户信息或null
     * @throws Exception 参数异常捕获
     */
     User save(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param id
     *            用户ID
     * @return 返回删除成功的用户信息或null
     */
    void delete(Integer id);

    /**
     * 查询用户信息
     *
     * @param id
     *            用户ID
     * @return 用户信息或null
     */
    User get(Integer id);

    /**
     * 用户列表
     *
     * @return 返回用户对象列表
     */
    List<User> list();

    /**
     * 分页
     * @return
     */
    Page<User> find(Integer page,Integer Size);

}
