package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Base_BrandServlet extends HttpServlet {
    /************重写service实现按路径名分配方法**************************/
    /******************反射**************************/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取最后一个/后面的路径
        String requestURI = req.getRequestURI();
        int index = requestURI.lastIndexOf("/");
        String substring = requestURI.substring(index + 1);

        //2.反射机制调用BrandServlet对应名称的方法
        Class<? extends Base_BrandServlet> cls = this.getClass();
        try {
            Method method = cls.getMethod(substring,HttpServletRequest.class, HttpServletResponse.class);
            try {
                method.invoke(this,req,resp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
