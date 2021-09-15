package com.qinh.repository;

import com.qinh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository来完成对数据库的操作
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-15-22:07
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
