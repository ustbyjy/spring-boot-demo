package com.ustbyjy.tasks;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer {

    private static String cron;

    public TaskCronChange() {
        // 默认情况是：每5秒执行一次
        cron = "0/5 * * * * *";
        new Thread(new Runnable() {
            // 开启新线程模拟外部更改了任务执行周期
            @Override
            public void run() {
                try {
                    // 让线程睡眠15秒
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改为：每10秒执行一次
                cron = "0/10 * * * * *";
                System.err.println("cron change to：" + cron);
            }
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 任务逻辑代码部分
                System.out.println("TaskCronChange task is running：" + new Date());
            }
        };

        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecutionTime = trigger.nextExecutionTime(triggerContext);
                return nextExecutionTime;
            }
        };

        taskRegistrar.addTriggerTask(task, trigger);
    }
}
