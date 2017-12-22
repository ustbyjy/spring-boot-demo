package com.ustbyjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getDomain());
                System.out.println(cookie.getPath());
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }
//        Cookie cookie = new Cookie("hello", "world");
//        cookie.setMaxAge(Integer.MAX_VALUE);
//        response.addCookie(cookie);
//        request.getSession().setAttribute("hello", "world");

        return "index";
    }

}
