package com.ustbyjy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cookie")
public class CookieController {
    private static Logger logger = LoggerFactory.getLogger(CookieController.class);

    private static final String SUCCESS = "success";
    private static final String NOT_FOUND = "404";
    private static final String ERROR = "error";

    /**
     * maxAge：过期时间，单位秒，为正数时cookie会持久化，为负数时cookie仅在本浏览器窗口以及本窗口打开的子窗口内有效
     *
     * @param name     cookie的name
     * @param value    cookie的value
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    @RequestMapping("set")
    public String setCookie(String name, String value, HttpServletRequest request, HttpServletResponse response) {
        logger.info("name={}，value={}", name, value);
        try {
            // 带domain
            Cookie cookie1 = new Cookie(name, value);
            cookie1.setDomain("zulong.com");
            cookie1.setPath("/");
            cookie1.setMaxAge(Integer.MAX_VALUE);

            // 不带domain，默认为应用的域名
            Cookie cookie2 = new Cookie(name, value);
            cookie2.setPath("/");
            cookie2.setMaxAge(Integer.MAX_VALUE);

            // 不带domain，带path
            Cookie cookie3 = new Cookie(name, value);
            cookie3.setPath("/cookie");
            cookie3.setMaxAge(Integer.MAX_VALUE);

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);

            return SUCCESS;
        } catch (Exception e) {
            logger.error("set cookie error", e);
            return ERROR;
        }
    }

    /**
     * 从客户端读取Cookie时，包括maxAge在内的其他属性都是不可读的，也不会被提交。浏览器提交Cookie时只会提交name与value属性。maxAge属性只被浏览器用来判断Cookie是否过期。
     *
     * @param name     cookie的name
     * @param value    cookie的value
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    @RequestMapping("get")
    public String getCookie(String name, String value, HttpServletRequest request, HttpServletResponse response) {
        logger.info("name={}", name);
        try {
            boolean found = false;
            for (Cookie cookie : request.getCookies()) {
                logger.info("name={}，value={}，domain={}，path={}，maxAge={}", cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getMaxAge());
                if (cookie.getName().equals(name)) {
                    found = true;
                }
            }

            return found ? SUCCESS : NOT_FOUND;
        } catch (Exception e) {
            logger.error("set cookie error", e);
            return ERROR;
        }
    }

    /**
     * maxAge为0，表示删除cookie
     *
     * @param name     cookie的name
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    @RequestMapping("delete")
    public String deleteCookie(String name, HttpServletRequest request, HttpServletResponse response) {
        logger.info("name={}", name);
        try {
            for (Cookie cookie : request.getCookies()) {
                logger.info("name={}，value={}，domain={}，path={}，maxAge={}", cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getMaxAge());
                if (cookie.getName().equals(name)) {
                    // 不设置domain则默认为应用的域名
                    cookie.setDomain("zulong.com");
                    // 不设置path则默认为根目录"/"
                    cookie.setPath("/");
                    cookie.setMaxAge(0);

                    response.addCookie(cookie);

                    return SUCCESS;
                }
            }

            return NOT_FOUND;
        } catch (Exception e) {
            logger.error("set cookie error", e);
            return ERROR;
        }
    }

}
