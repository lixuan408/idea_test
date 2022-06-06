package com.itheima.web.servlet;

import com.itheima.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = {"/checkCodeServlet"})
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.生成验证码
        ServletOutputStream os = response.getOutputStream();
        String s = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);


        //2.
        HttpSession session = request.getSession();
        session.setAttribute("VerifyCode",s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
