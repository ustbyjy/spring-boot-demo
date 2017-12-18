package com.ustbyjy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/i18n")
public class I18nController {

    private static Logger logger = LoggerFactory.getLogger(I18nController.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * 三种方式获取Locale：
     * 1、直接写在参数列表中，Spring MVC自动装填
     * 2、LocaleContextHolder.getLocale()；
     * 3、RequestContextUtils.getLocale(request)；
     *
     * @param request 请求
     * @param locale  本地化
     * @return
     */
    @RequestMapping(value = {"", "/"})
    public String index(HttpServletRequest request, Locale locale) {
        logger.error("locale1: " + locale);

        Locale locale2 = LocaleContextHolder.getLocale();
        logger.error("locale2: " + locale2);

        Locale locale3 = RequestContextUtils.getLocale(request);
        logger.error("locale3: " + locale3);

        String msg = messageSource.getMessage("welcome", null, locale);
        logger.error("msg: " + msg);

        return "i18n";
    }
}
