package com.ustbyjy;

import com.ustbyjy.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017-03-06
 * Time: 21:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class Chapter3JdbcApplicationTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService.deleteAllUsers();
    }

    @Test
    public void testUserService() {
        userService.create("a", 10);
        userService.create("b", 11);
        userService.create("c", 12);
        userService.create("d", 13);
        userService.create("e", 14);

        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.deleteByName("d");
        userService.deleteByName("e");

        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }

}
