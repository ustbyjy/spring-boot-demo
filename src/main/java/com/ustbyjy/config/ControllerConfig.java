package com.ustbyjy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerConfig {

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        return this.resourceUrlProvider;
    }

    @ModelAttribute("bathPath")
    public String bathPath() {
        return httpServletRequest.getContextPath();
    }
}
