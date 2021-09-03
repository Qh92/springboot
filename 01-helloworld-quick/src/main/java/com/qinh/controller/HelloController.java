package com.qinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody加在类上表明这个类的所有方法返回的数据直接写给浏览器（如果是对象可以转为JSON数据）
 *
 * @author Qh
 * @version 1.0
 * @date 2021/9/3 14:46
 */
/*@ResponseBody
@Controller*/
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot quick";
    }

}
