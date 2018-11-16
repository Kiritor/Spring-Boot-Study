/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: UserSqlProvider
 */
package com.kiritor.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 〈复杂查询动态SQL〉
 *
 * @author lcore
 * @create 18/11/2
 * @since 1.0.0
 */

public class UserSqlProvider {

    /**
     * 模糊查询用户
     * @param key
     * @return
     */
    public String getUserListByKey(@Param("key") String key){
       String sql = "select * from t_user obj where obj.user_name like '%"+key+"%' ";
       return sql;
    }


    public String getUserListByKey1(@Param("key") String key) {
        return new SQL() {{
            SELECT("*");
            FROM("t_user");
            if (key != null) {
                WHERE("user_name like #{key}");
            } else {
                WHERE("1=1");
            }
        }}.toString();
    }
}
