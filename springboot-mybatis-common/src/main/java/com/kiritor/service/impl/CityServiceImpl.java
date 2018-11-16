/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserServiceImpl
 */
package com.kiritor.service.impl;

import com.kiritor.entity.City;
import com.kiritor.mapper.branch01.CityMapper;
import com.kiritor.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/14
 * @since 1.0.0
 */
@Service
public class CityServiceImpl extends BaseServiceImpl<City> implements CityService {

    @Resource
    CityMapper cityMapper;

    @Override
    public City getCityById(Integer id) throws Exception{
        return this.getObjById(id);
    }
}
