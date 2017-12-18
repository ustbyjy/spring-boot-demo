package com.ustbyjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/6
 * Time: 17:22
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
//        request.getSession().setAttribute("hello", "world");
        return "index";
    }

}
