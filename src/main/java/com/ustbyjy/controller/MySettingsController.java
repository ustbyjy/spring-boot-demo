package com.ustbyjy.controller;

import com.ustbyjy.config.MySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/6
 * Time: 17:22
 */
@RestController
public class MySettingsController {

    @Autowired
    private MySettings mySettings;

    @RequestMapping("/my_settings")
    public MySettings mySettings(HttpServletRequest httpServletRequest) {
        
        return mySettings;
    }

}
