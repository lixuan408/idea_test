package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class test {


    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper BrandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = BrandMapper.selectAll();

        System.out.println(brands);
    }
}
