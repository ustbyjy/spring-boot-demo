package com.ustbyjy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class UrlMatchConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        // 设置是否使用后缀模式匹配，如"/user"是否匹配"/user.*"，默认true
        configurer.setUseSuffixPatternMatch(false);
        // 设置是否使用反斜杠匹配，如"/user"是否匹配"/user/"，默认true
        configurer.setUseTrailingSlashMatch(true);
    }
}
