package com.kiritor.service.impl;

import com.kiritor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondaryJdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        primaryJdbcTemplate.update("insert into T_USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        primaryJdbcTemplate.update("delete from T_USER where NAME = ?", name);
    }

    @Override
    public List<Map<String,Object>> getAllUsers() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.addAll(primaryJdbcTemplate.queryForList("select * from t_user"));
        list.addAll(secondaryJdbcTemplate.queryForList("select * from userinfo"));
        return list;
    }

    @Override
    public void deleteAllUsers() {
        primaryJdbcTemplate.update("delete from T_USER");
    }

}
