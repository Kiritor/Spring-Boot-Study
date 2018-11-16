/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: ResultsUtil
 */
package com.kiritor.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.reflect.Field;

/**
 * 〈结果集映射生成器〉
 *
 * @author lcore
 * @create 18/11/2
 * @since 1.0.0
 */

public class ResultsUtil {

    /**
     * 生成映射关系
     * @param origin
     * @return
     */
    public static String generateResults(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toUpperCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }



}
