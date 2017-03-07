package com.yanwang.controller;

import com.yanwang.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/6
 * Time: 17:22
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("host", "http://blog.didispace.com");

        return "index";
    }

    @RequestMapping("/index2")
    public String index2(Model model) {
        model.addAttribute("host", "http://blog.didispace.com");

        return "index2";
    }

    @RequestMapping("/index3")
    public String index3(Model model) {
        model.addAttribute("host", "http://blog.didispace.com");

        return "index3";
    }

    @RequestMapping("/testError")
    public String testError(Model model) throws Exception {
        throw new Exception("测试错误");
    }

    @RequestMapping("/testError2")
    public String testError2(Model model) throws Exception {
        throw new MyException("测试错误2");
    }
}
