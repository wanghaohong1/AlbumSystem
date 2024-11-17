package com.whh.aop;

import com.whh.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行的方法
        // 返回true表示继续执行请求，返回false表示终止请求
        User user = (User) request.getSession().getAttribute("user");
        String requestUri = request.getRequestURI();
        if (user == null) {
            if (!requestUri.endsWith("/login.html") && !requestUri.endsWith("/register.html")) {
                // 重定向到登录页面或注册页面
                response.sendRedirect(request.getContextPath() + "/pages/login.html");
                return false; // 终止请求
            }
        }
        return true; // 继续执行请求
    }
}
