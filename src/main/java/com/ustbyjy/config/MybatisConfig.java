package com.ustbyjy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ustbyjy.mapper")
public class MybatisConfig {

}
