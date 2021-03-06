package com.ustbyjy.exception;

import com.ustbyjy.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description: 通过@ControllerAdvice，可以将对于Controller的全局配置放置在同一个位置，
 * 对于@ExceptionHandler、@InitBinder、@ModelAttribute注解有效，
 * 此例就是全局异常处理，用到了@ExceptionHander注解
 * User: Administrator
 * Date: 2017/3/7
 * Time: 12:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleDefaultError(HttpServletRequest request, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.addObject("url", request.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);

        return mv;
    }

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ErrorInfo<String> handleJsonError(HttpServletRequest request, MyException e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some Data");
        errorInfo.setUrl(request.getRequestURL().toString());

        return errorInfo;
    }
}
