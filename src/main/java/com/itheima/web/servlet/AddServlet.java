package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addServlet"})
public class AddServlet extends HttpServlet {

    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /****************jsp*****************************/
     /*   request.setCharacterEncoding("UTF-8");
        //1.获取req中的数据
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //2.把数据封装成Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        brand.setOrdered(Integer.parseInt(ordered));

        //3.调用add
        service.add(brand);

        //4.展示新的表格
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);*/

        /*************vue+axios****************************/
        String post = request.getReader().readLine();
        Brand brand = JSON.parseObject(post, Brand.class);

        if(brand.getBrandName().equals("")||brand.getCompanyName().equals("")){
            response.getWriter().write("false");
        }else{
            service.add(brand);
            response.getWriter().write("true");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
