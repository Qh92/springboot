package com.qinh.impl;

import com.qinh.Search;

import java.util.List;

/**
 * 实现接口从数据库查询
 *
 * @author Qh
 * @version 1.0
 * @date 2022-01-17 22:58
 */
public class DatabaseSearch implements Search {
    @Override
    public List<String> search(String keyword) {
        System.out.println("now use database search. keyword:" + keyword);
        return null;
    }
}
