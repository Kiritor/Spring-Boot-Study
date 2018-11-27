/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserJpa
 */
package com.kiritor.repository;

import com.kiritor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/16
 * @since 1.0.0
 */

public interface UserRepository extends
        JpaRepository<User, Long>,
        Serializable {
    @Query("select t from User t where t.userName = ?1")
    List<User> finByUserName(String username);
}
