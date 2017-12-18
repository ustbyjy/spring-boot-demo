package com.ustbyjy.controller;

import com.ustbyjy.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("add")
    @ResponseBody
    private String add(@Valid Student student, BindingResult result, Model model) {
        // 自定义错误返回消息
        result.reject("name", new Object[]{"illegal"}, "用户名不合法");

        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
            }
            return "error";
        }
        return "success";
    }
}
