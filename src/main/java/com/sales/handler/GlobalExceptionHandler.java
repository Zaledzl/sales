package com.sales.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
//标识，让SpringBoot认为这是一个统一的异常处理类
//这个东西和前端页面直接做交互
//建议针对不同的service的方法 编写不同的异常处理方法 去catch住自己定义的Exception
//针对service的业务逻辑写
//这里编写的是异常的处理方法
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    //定义指定的异常处理类
    @ResponseBody
    //不是返回HTML页面而是返回错误信息  所以要 @ResponseBody
    //不是返回HTML页面都要写 @ResponseBody

    //编写异常处理方法
    //有两个参数

    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        //返回值是一个Map对象
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        //一般情况下要做出对应的处理
        //给用户抛出具体的信息  并记录错误日志
        //更加人性化
        return modelMap;


    }
}
