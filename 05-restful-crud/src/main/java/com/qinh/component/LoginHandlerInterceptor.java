package com.qinh.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 进行登录检查
 *
 * @author Qh
 * @version 1.0
 * @date 2021-09-05-22:13
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            //未登录，返回登录页面
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }else {
            //已登录,放行请求
            return true;
        }

    }
}
