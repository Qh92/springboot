package com.qinh.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:告诉Springboot将本类中的所有属性和配置文件中相关的属性进行绑定,默认从全局配置文件中获取配置
 *      prefix = "person":配置文件中的哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 *
 * @author Qh
 * @version 1.0
 * @date 2021/9/3 15:36
 */
@ConfigurationProperties(prefix = "person")
//@Validated
//@PropertySource(value = {"classpath:person.properties"})
@Component
public class Person {

    /**
     * <bean class="Person">
     *     <property name="lastName" value="字面量"></property>
     * </bean>
     */
    //@Value("${person.last-name}")
    //lastName必须是邮箱格式
    //@Email
    private String lastName;

    //@Value("#{10 * 2}")
    private int age;

    //@Value("true")
    private boolean boss;

    private Date birth;

    //@Value("${person.maps}")
    //@Value不支持复杂类型封装
    private Map<String,Object> maps;

    private List<Object> lists;

    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }


}
