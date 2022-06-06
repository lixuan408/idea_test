package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public List<Brand> selectAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper BrandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = BrandMapper.selectAll();

        //查询不需要提交事务
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.addBrand(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);

        sqlSession.close();
        return brand;
    }

    public void update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.delete(id);

        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deletByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    /**************分页查询*******************************/
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;


        List<Brand> brands = brandMapper.selectByPage(begin, size);
        int total = brandMapper.selectTotalCount();

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(brands);
        brandPageBean.setTotalCount(total);

        sqlSession.close();
        return brandPageBean;
    }


    public PageBean<Brand> selectByPageAndConditions(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        if (brand.getBrandName() != null && brand.getBrandName().equals("")==false) {
            String brandName = brand.getBrandName();
            brand.setBrandName("%" + brandName + "%");
        }

        if (brand.getCompanyName() != null && brand.getCompanyName().equals("")==false) {
            String companyName = brand.getCompanyName();
            brand.setCompanyName("%" + companyName + "%");
        }

        List<Brand> brands = brandMapper.selectByConditions(brand, begin, size);
        int total = brandMapper.selectTotalCountXXX1(brand);

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(brands);
        brandPageBean.setTotalCount(total);
        sqlSession.close();
        return brandPageBean;
    }
}
