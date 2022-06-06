package com.itheima.web.servlet;

import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/selectUserServlet"})
public class SelectUserServlet extends HttpServlet {
    private UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.
        String username = request.getParameter("username");

        //2.
        boolean checkUsername = userService.checkUsername(username);
        //3.响应
        response.getWriter().write(""+checkUsername);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
