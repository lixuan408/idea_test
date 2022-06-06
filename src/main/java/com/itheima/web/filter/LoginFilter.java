/*package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


*//* *   登录验证的过滤器
 * *//*
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;

        //判断访问的资源路径是否和登录注册相关
        String[] urls = {"/brand_demo/login.jsp", "/brand_demo/imgs/", "/brand_demo/css/", "/brand_demo/loginServlet", "/brand_demo/register.jsp", "/brand_demo/registerServlet", "/brand_demo/checkCodeServlet","/brand_demo/register.html","/brand_demo/selectUserServlet","/brand_demo/js/","/brand_demo/index.html","/brand_demo"};

        String requestURI = request1.getRequestURI();

        for (String url : urls) {
            if(requestURI.contains(url)){

                *//************放行****************//*
                chain.doFilter(request, response);
                return;
            }
        }


        //1.判断
        HttpSession session = request1.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            *//************放行****************//*
            chain.doFilter(request, response);
        } else {
            request1.setAttribute("Login_msg", "用户未登录！");
            request1.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}*/
