package com.yanwang;

import com.yanwang.async.Task;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import static org.apache.log4j.Logger.getLogger;

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
    private static Logger logger = getLogger(SpringBootDemoApplication.class);

    @Autowired
    private Task task;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

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

    @Test
    public void mailTest() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ustbyjy@163.com");
        message.setTo("ustbyjy@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    @Test
    public void mimeMailTest() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("ustbyjy@163.com");
        helper.setTo("ustbyjy@163.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashMap<>();
        model.put("userName", "didi");
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mail.vm", "UTF-8", model);
        helper.setText(text, true);
        mailSender.send(mimeMessage);
    }

}
