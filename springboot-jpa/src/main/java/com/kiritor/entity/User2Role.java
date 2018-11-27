/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: User2Role
 */
package com.kiritor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 〈用户角色关系〉
 *
 * @author lcore
 * @create 18/11/16
 * @since 1.0.0
 */


@Entity
@Table(name = "T_USER2ROLE")
public class User2Role implements Serializable {
    /**
     自增主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer roleId;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
