package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/selectAllServlet"})
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /***********老版本jsp实现*************************/
     /*   //1.调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();

        //2.存入request域中
        request.setAttribute("brands",brands);

        //3.转发到brand.jps中
        request.getRequestDispatcher("/brand.jsp").forward(request, response);*/

        /*********vue+axios******************************/
        //1.调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();


        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/Json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
