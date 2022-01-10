package com.qinh.controller;

import com.qinh.listener.MyHttpSessionListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-04-16:10
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpSession session){
        session.setAttribute("username", "qinh");
        return "hello";
    }

    @RequestMapping("online")
    public String online(){
        return "当前在线人数："+ MyHttpSessionListener.online +"人";
    }
}
