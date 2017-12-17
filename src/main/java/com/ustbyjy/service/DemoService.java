package com.ustbyjy.service;

import com.ustbyjy.domain.Demo;
import com.ustbyjy.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<Demo> likeName(String name) {
        return demoMapper.likeName(name);
    }
    
}
