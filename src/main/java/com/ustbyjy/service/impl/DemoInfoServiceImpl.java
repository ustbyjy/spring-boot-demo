package com.ustbyjy.service.impl;

import com.ustbyjy.dao.DemoInfoRepository;
import com.ustbyjy.domain.DemoInfo;
import com.ustbyjy.service.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoInfoServiceImpl implements DemoInfoService {

    @Resource
    private DemoInfoRepository demoInfoRepository;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Cacheable(value = "demoInfo")
    @Override
    public DemoInfo findById(Long id) {
        System.err.println("DemoInfoServiceImpl.findById()-->从数据库中进行获取的，id=" + id);
        return demoInfoRepository.findOne(id);
    }

    @CacheEvict(value = "demoInfo")
    @Override
    public void deleteFromCache(Long id) {
        System.out.println("DemoInfoServiceImpl.delete()-->从缓存中删除，id=" + id);
    }

    @Override
    public void test() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myKey1", "random1=" + Math.random());
        System.out.println(valueOperations.get("myKey1"));
    }
}
