/**
 * Copyright (C), 2014-2018, xx有限公司
 * FileName: Branch01DataSourceConfig
 */
package com.kiritor.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 〈从数据源01配置〉
 *
 * @author lcore
 * @create 18/11/15
 * @since 1.0.0
 */


@Configuration
@MapperScan(basePackages = Branch01DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "branch01SqlSessionFactory")
public class Branch01DataSourceConfig {
    /**
     * 从据源01目录
     */
    static final String PACKAGE = "com.kiritor.mapper.branch01";
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/branch01/*.xml";

    @Bean(name = "branch01DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.branch01")
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "branch01TransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("branch01DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "branch01SqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("branch01DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    @Bean(name = "branch01SqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("branch01SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
