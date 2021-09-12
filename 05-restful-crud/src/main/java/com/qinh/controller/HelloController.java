package com.qinh.controller;

import com.qinh.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-04-21:10
 */

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user){
        if ("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "hello world";
    }


    /**
     * 查出一些数据，在页面展示
     */
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
