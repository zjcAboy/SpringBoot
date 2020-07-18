package com.example.chapter542.Config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    //提供了两个数据源
    //dsOne dsTwo 默认方法名即是实例名
    //@ConfigurationProperties注解表示使用不同前缀配置文件创建不同的DataSource实例
    @Bean
    @ConfigurationProperties("spring.datasource.one")
    DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.two")
    DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
