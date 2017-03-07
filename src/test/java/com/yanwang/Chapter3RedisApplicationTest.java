package com.yanwang;

import com.yanwang.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
public class Chapter3RedisApplicationTest {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set("1", user);
        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set("2", user);
        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set("3", user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("1").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("2").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("3").getAge().longValue());
    }

}
