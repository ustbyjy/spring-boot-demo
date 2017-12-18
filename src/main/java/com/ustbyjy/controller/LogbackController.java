package com.ustbyjy.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {

    @RequestMapping(value = "/getLogLevel")
    public Level getLogLevel(@RequestParam(value = "package") String packageName) throws Exception {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        return loggerContext.getLogger(packageName).getLevel();
    }

    @RequestMapping(value = "logLevel/{logLevel}")
    public String logLevel(@PathVariable("logLevel") String logLevel,
                           @RequestParam(value = "package") String packageName) {

        LoggerContext loggerContext =(LoggerContext)LoggerFactory.getILoggerFactory();
        loggerContext.getLogger(packageName).setLevel(Level.valueOf(logLevel));

        return "ok";
    }
}
