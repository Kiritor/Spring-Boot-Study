/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: BaseService
 */
package com.kiritor.service;

import java.util.List;

/**
 * 〈通用service〉
 *
 * @author lcore
 * @create 18/11/13
 * @since 1.0.0
 */

public interface BaseService<T> {

    /**
     * 根据主键获取记录
     * @param id
     * @return
     * @throws Exception
     */
     T getObjById(Integer id) throws Exception;

    /**
     * 获取所有对象
     * @return
     * @throws Exception
     */
     List<T> getObjList() throws Exception;

    /**
     * 保存记录,返回记录
     * @param entity
     * @return
     * @throws Exception
     */
     T save(T entity) throws Exception;

    /**
     * 更新记录
     * @param entity
     * @throws Exception
     */
     void update(T entity) throws Exception;

    /**
     * 根据主键删除记录
     * @param id
     * @throws Exception
     */
     void delete(Integer id) throws Exception;

}
