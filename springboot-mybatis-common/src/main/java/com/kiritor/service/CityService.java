/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserService
 */
package com.kiritor.service;

import com.kiritor.entity.City;

/**
 * 〈〉
 *
 * @author lcore
 * @create 18/11/14
 * @since 1.0.0
 */

public interface CityService extends BaseService<City> {
    /**
     * 根据id得到城市
     * @param id
     * @return
     */
    City getCityById(Integer id) throws Exception;
}
