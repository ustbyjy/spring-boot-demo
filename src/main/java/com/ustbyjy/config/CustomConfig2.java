package com.ustbyjy.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class CustomConfig2 {

    @Bean
    @ConditionalOnMissingBean(name = "filterChainDefinitionMap")
    public LinkedHashMap<String, String> filterChainDefinitionMap() {
        System.out.println("加载了新bean");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("assets/**", "anon");
        filterChainDefinitionMap.put("index.html", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        return new LinkedHashMap<>();
    }
}
