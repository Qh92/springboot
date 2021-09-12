package com.qinh.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义Filter
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-11-13:21
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
