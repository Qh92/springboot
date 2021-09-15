package com.qinh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 使用JPA注解配置映射关系
 * @Entity:告诉JPA这是一个实体类（和数据表映射的类）
 * @Table:来指定和哪个数据表对应，如果省略默认表名就是user
 * @JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
 *      使用jpa做增删改查的时候出现了这个异常，原因是转化成json的时候，fasterxml.jackson将对象转换为json报错，发现有字段为null
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-15-21:58
 */
@Entity
@Table(name = "tbl_user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class User implements Serializable {


    /**
     * Id:这是一个主键
     * GeneratedValue(strategy = GenerationType.IDENTITY):自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Column(name = "last_name",length = 50):这是和数据表对应的一个列
     */
    @Column(name = "last_name",length = 50)
    private String lastName;

    /**
     * 省略默认列名就是属性名
     */
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
