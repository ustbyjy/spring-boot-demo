package com.yanwang;

import com.yanwang.service.impl.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/6
 * Time: 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class Chapter2ApplicationTest {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test() {
        Assert.assertEquals("程序员DD", blogProperties.getName());
        Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
        System.out.println("desc: " + blogProperties.getDesc());
        System.out.println("value: " + blogProperties.getValue());
        System.out.println("number: " + blogProperties.getNumber());
        System.out.println("bigNumber: " + blogProperties.getBigNumber());
        System.out.println("test1: " + blogProperties.getTest1());
        System.out.println("test2: " + blogProperties.getTest2());
        System.out.println("port: " + blogProperties.getPort());
    }
}
