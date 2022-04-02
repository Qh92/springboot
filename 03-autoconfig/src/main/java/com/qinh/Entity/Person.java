package com.qinh.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Qh
 * @version 1.0
 * @date 2022/4/2 14:49
 */
@Component
public class Person {

    @Value("${time}")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "time='" + time + '\'' +
                '}';
    }
}
