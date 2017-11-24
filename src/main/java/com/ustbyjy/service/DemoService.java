package com.ustbyjy.service;

import com.ustbyjy.dao.DemoRepository;
import com.ustbyjy.domain.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    @Resource
    private DemoRepository demoRepository;

    public void save(Demo demo) {
        demoRepository.save(demo);
    }
}
