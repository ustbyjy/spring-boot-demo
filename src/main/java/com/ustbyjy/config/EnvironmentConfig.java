package com.ustbyjy.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
        // 通过 environment 获取到系统属性
        System.out.println(environment.getProperty("JAVA_HOME"));

        // 通过 environment 同样能获取到application.properties配置的属性
        System.out.println(environment.getProperty("spring.datasource.url"));

        // 获取到前缀是"spring.datasource." 的属性列表值
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println("spring.datasource.url=" + relaxedPropertyResolver.getProperty("url"));
        System.out.println("spring.datasource.driverClassName=" + relaxedPropertyResolver.getProperty("driverClassName"));
    }
}
