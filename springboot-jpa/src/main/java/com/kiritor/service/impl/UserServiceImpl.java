/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserServiceImpl
 */
package com.kiritor.service.impl;

import com.kiritor.entity.User;
import com.kiritor.repository.UserRepository;
import com.kiritor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/16
 * @since 1.0.0
 */


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(Long.parseLong(id.toString()));
    }

    @Override
    public User get(Integer id) {
        return userRepository.getOne(Long.parseLong(id.toString()));
    }

    @Override
    public Page<User> find(Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}