package com.qinh.config;

import com.qinh.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类,就是来替代之前的Spring配置文件
 * 在配置文件中用<bean></bean>标签添加组件
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-03-22:28
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
     *
     * @return
     */
    @Bean
    public HelloService helloService01(){
        System.out.println("配置类@Bean给容器中添加组件了");
        return new HelloService();
    }
}
