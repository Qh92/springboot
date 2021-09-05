package com.qinh;

import com.qinh.bean.Person;
import com.qinh.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    HelloService helloService;

    @Test
    public void testBean(){
        helloService.setName("qinh");
        System.out.println(helloService.getName());
    }

    @Test
    public void testHelloService(){
        boolean helloService = ioc.containsBean("helloService01");
        System.out.println(helloService);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
