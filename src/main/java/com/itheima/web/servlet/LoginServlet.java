package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /******************jsp版本*********************************/
     /*   request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");



        User user = userService.login(username, password);

        if (user != null) {
            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
                Cookie c_password = new Cookie("password", URLEncoder.encode(password,"UTF-8"));
                c_password.setMaxAge(3600*24*7);
                c_username.setMaxAge(3600*24*7);
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            *//*request.getRequestDispatcher("/selectAllServlet").forward(request, response);*//*
            response.sendRedirect("http://localhost:8080/brand_demo/6-brand.html");
        } else {
            //登陆失败

            //1.存储错误信息到request域中
            request.setAttribute("login_error_msg", "用户名或密码错误！");

            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }*/

        /***************vue+axios**************************************/

        request.setCharacterEncoding("UTF-8");
        String s = request.getReader().readLine();
        User user1 = JSON.parseObject(s, User.class);

        User user = userService.login(user1.getUsername(), user1.getPassword());

        if (user != null) {

            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("true".equals(user1.getRemember())) {
                System.out.println("11111111111111111111111111111111111111111111");
                Cookie c_username = new Cookie("username", URLEncoder.encode(user1.getUsername(),"UTF-8"));
                Cookie c_password = new Cookie("password", URLEncoder.encode(user1.getPassword(),"UTF-8"));
                c_password.setMaxAge(3600*24*7);
                c_username.setMaxAge(3600*24*7);
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            /*request.getRequestDispatcher("/selectAllServlet").forward(request, response);*/

            response.getWriter().write("true");
        } else {
            //登陆失败

            //1.存储错误信息到request域中
            response.setContentType("text/Json;charset=utf-8");
            response.getWriter().write("用户名或密码错误！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
