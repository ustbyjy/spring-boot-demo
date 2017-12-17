package com.ustbyjy.controller;

import com.ustbyjy.domain.Demo;
import com.ustbyjy.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/likeName")
    public List<Demo> likeName(String name) {
        List<Demo> result = demoService.likeName(name);
        return result;
    }
}
