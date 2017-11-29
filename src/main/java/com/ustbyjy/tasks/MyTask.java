package com.ustbyjy.tasks;

import org.springframework.scheduling.annotation.Scheduled;

public class MyTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void work() {
        System.out.println(">>>>>>do work<<<<<<");
    }
}
