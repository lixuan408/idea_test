package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/brand/*"})
public class BrandServlet extends Base_BrandServlet {
    private BrandService brandService = new BrandService();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*********vue+axios+反射******************************/
        //1.调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();

        System.out.println("反射解法！！！");
        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/Json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*************vue+axios+反射****************************/
        System.out.println("反射解法！！！");
        String post = request.getReader().readLine();
        Brand brand = JSON.parseObject(post, Brand.class);

        if (brand.getBrandName().equals("") || brand.getCompanyName().equals("")) {
            response.getWriter().write("false");
        } else {
            brandService.add(brand);
            response.getWriter().write("true");
        }
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*************vue+axios+反射****************************/
        System.out.println("反射解法！！！");
        String post = request.getReader().readLine();
        int[] ids = JSON.parseObject(post, int[].class);

        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*************vue+axios+反射****************************/
        System.out.println("反射解法！！！");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(brandPageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("反射解法！！！");

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        String post = request.getReader().readLine();
        Brand brand = JSON.parseObject(post, Brand.class);

        System.out.println(post);
        PageBean<Brand> brandPageBean = brandService.selectByPageAndConditions(currentPage, pageSize, brand);
        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

}
