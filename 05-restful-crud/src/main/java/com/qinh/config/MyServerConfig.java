package com.qinh.config;

import com.qinh.filter.MyFilter;
import com.qinh.listener.MyListener;
import com.qinh.servlet.MyServlet;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.JettyWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.jetty.ConfigurableJettyWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-11-13:13
 */
@Configuration
public class MyServerConfig {


    /**
     * 注册三大组件
     */

    /**
     * 注册Servlet组件
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return listenerRegistrationBean;
    }

    /**
     * 配置嵌入式的Servlet容器
     *
     * @param environment
     * @param serverProperties
     * @return
     */
    @Bean
    public TomcatWebServerFactoryCustomizer tomcatWebServerFactoryCustomizer2(Environment environment, ServerProperties serverProperties){
        return new TomcatWebServerFactoryCustomizer(environment, serverProperties){
            @Override
            public void customize(ConfigurableTomcatWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    /*@Bean
    public JettyWebServerFactoryCustomizer jettyWebServerFactoryCustomizer2(Environment environment, ServerProperties serverProperties){
        return new JettyWebServerFactoryCustomizer(environment, serverProperties){
            @Override
            public void customize(ConfigurableJettyWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }*/

    //EmbeddedWebServerFactoryCustomizerAutoConfiguration

}
