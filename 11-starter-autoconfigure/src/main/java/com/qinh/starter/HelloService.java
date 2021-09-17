package com.qinh.starter;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-17-21:43
 */
public class HelloService {


    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sqyHello(String name){
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();

    }
}
