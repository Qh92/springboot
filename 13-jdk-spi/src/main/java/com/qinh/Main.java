package com.qinh;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPI的全称是Service Provider Interface,
 * 直译过来就是"服务提供接口", 听起来挺别扭的, 所以我试着去理解了一下, 就将它翻译为"服务提供商接口"吧.
 *
 * 我们都知道, 一个接口是可以有很多种实现的.
 * 例如搜索,可以是搜索系统的硬盘,也可以是搜索数据库.系统的设计者为了降低耦合,并不想在硬编码里面写死具体的搜索方式,
 * 而是希望由服务提供者来选择使用哪种搜索方式, 这个时候就可以选择使用SPI机制.
 *
 * @author Qh
 * @version 1.0
 * @date 2022-01-17 23:03
 */
public class Main {

    public static void main(String[] args) {
        // 测试SPI
        System.out.println("hello SPI");

        ServiceLoader<Search> loader = ServiceLoader.load(Search.class);

        Iterator<Search> searchs = loader.iterator();

        while (searchs.hasNext()) {
            Search currentClass = searchs.next();
            currentClass.search("hello SPI");
        }
    }
}
