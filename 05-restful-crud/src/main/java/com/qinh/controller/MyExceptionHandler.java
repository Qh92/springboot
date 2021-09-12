package com.qinh.controller;

import com.qinh.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-11-11:31
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 浏览器和客户端返回的都是json
     *
     * @param e
     * @return
     */
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,String> handleException(Exception e){
        Map<String,String> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx
        /*
        String ERROR_STATUS_CODE = "javax.servlet.error.status_code";
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
         */
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE,500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());

        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}
