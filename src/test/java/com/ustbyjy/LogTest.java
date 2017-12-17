package com.ustbyjy;

import com.ustbyjy.domain.Demo;
import com.ustbyjy.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@ActiveProfiles("dev")
public class LogTest {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testDemoMapper() {
        List<Demo> demoList = demoMapper.likeName("hello");
        System.out.println(demoList.size());
    }
}
