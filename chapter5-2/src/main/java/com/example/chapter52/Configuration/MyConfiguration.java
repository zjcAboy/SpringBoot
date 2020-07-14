package com.example.chapter52.Configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.chapter52.mapper")
public class MyConfiguration {
}
