package com.itheima.web.servlet;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/selectByIdServlet"})
public class SelectByIdServlet extends HttpServlet {

    private BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);

        Brand brand = brandService.selectById(i);

        request.setAttribute("brand",brand);

        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
