package com.yanwang;

import com.yanwang.async.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017-03-06
 * Time: 21:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class Chapter4ApplicationTest {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SpringBootDemoApplication.class);

    @Autowired
    private Task task;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        logger.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
