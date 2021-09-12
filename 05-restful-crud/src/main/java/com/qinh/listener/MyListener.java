package com.qinh.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-11-13:26
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized -----> web应用启动");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed ----> 当前web项目销毁");
    }
}
