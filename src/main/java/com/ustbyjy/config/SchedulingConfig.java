package com.ustbyjy.config;

import com.ustbyjy.tasks.MyTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Bean
    public MyTask myTask() {
        return new MyTask();
    }
}
