package com.example.chapter541.Configration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
//提供两个Jdbc实例,每个实例需要提供DataSource生成
@Configuration
public class JdbcTemplateConfig {
    @Bean
    //@Qualifier注解表示查找不同名称的DataSource实例注入进来
    JdbcTemplate jdbcTemplateOne (@Qualifier("dsOne")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    JdbcTemplate jdbcTemplateTwo (@Qualifier("dsTwo")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
