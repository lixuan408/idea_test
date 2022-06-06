package com.itheima.web.servlet;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //1.获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute("VerifyCode");

        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.setAttribute("checkCode",checkCode);

        //2.把数据封装成User
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        //3.调用
        if (!value.equalsIgnoreCase(checkCode)) {
            request.setAttribute("VerifyCode_msg","验证码错误！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        if (userService.register(user)) {
            //注册成功，跳转登录页面
            request.setAttribute("register_msg", "注册成功，请登录！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //注册失败,跳转到注册页面
            request.setAttribute("register_msg", "用户名已经存在！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }


}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
