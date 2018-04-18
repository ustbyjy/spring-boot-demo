package com.ustbyjy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class CustomConfig1 {

    @Bean
    public LinkedHashMap<String, String> filterChainDefinitionMap() {
        System.out.println("加载了原始bean");
        return new LinkedHashMap<>();
    }

}
