package com.qinh.impl;

import com.qinh.Search;

import java.util.List;

/**
 * 实现接口从文件系统查询
 *
 * @author Qh
 * @version 1.0
 * @date 2022-01-17 22:58
 */
public class FileSearch implements Search {
    @Override
    public List<String> search(String keyword) {
        System.out.println("now use file system search. keyword:" + keyword);
        return null;
    }
}
