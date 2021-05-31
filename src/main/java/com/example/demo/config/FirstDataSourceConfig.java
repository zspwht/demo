package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
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
@MapperScan(basePackages = FirstDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDataSourceConfig {
    //mapper扫描路径
    static final String PACKAGE = "com.example.demo.mapper.first";
    //mapper xml扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/first/*.xml";

    @Primary
    @Bean("firstDataSource")
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean("firstTransactionManage")
    public DataSourceTransactionManager firstTransactionManage(){
        return new DataSourceTransactionManager(firstDataSource());
    }

    @Primary
    @Bean("firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(FirstDataSourceConfig.MAPPER_LOCATION));
        return  sessionFactoryBean.getObject();
    }
}
