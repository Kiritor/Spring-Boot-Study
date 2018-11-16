/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: BaseServiceImpl
 */
package com.kiritor.service.impl;

import com.kiritor.service.BaseService;
import com.kiritor.utils.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈通用service〉
 *
 * @author lcore
 * @create 18/11/13
 * @since 1.0.0
 */

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    private CommonMapper<T> mapper;


    @Override
    public T getObjById(Integer id) throws Exception {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> getObjList() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public T save(T entity) throws Exception {
        mapper.insertSelective(entity);
        return mapper.selectOne(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Integer id) throws Exception {
        mapper.deleteByPrimaryKey(id);
    }
}
