package com.example.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author zsp
 * @Date 2021/5/27 15:20
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = SecondDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfig {
    //mapper扫描路径
    static final String PACKAGE = "com.example.demo.mapper.second";
    //mapper xml扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/second/*.xml";

    @Bean("secondDataSource")
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean("secondTransactionManage")
    public DataSourceTransactionManager secondTransactionManage(){
        return new DataSourceTransactionManager(secondDataSource());
    }

    @Bean("secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDataSourceConfig.MAPPER_LOCATION));
        return  sessionFactoryBean.getObject();
    }
}
