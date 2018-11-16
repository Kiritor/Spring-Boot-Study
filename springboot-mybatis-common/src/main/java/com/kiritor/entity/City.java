/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: City
 */
package com.kiritor.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈城市〉
 *
 * @author lcore
 * @create 18/11/15
 * @since 1.0.0
 */

@Table(name ="T_CITY")
public class City {

    /**
     自增主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
