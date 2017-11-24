package com.ustbyjy;

import com.ustbyjy.domain.User;
import com.ustbyjy.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017-03-06
 * Time: 21:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@Transactional
public class Chapter3MyBatisApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Rollback
    public void testUserMapper() {
        userMapper.insert("AAA", 20);
        User user = userMapper.findByName("AAA");
        Assert.assertEquals(20, user.getAge().intValue());
    }

}
