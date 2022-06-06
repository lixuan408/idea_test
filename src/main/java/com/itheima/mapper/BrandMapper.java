package com.itheima.mapper;


import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {


    //查询所有
    List<Brand> selectAll();

    void addBrand(Brand brand);

    Brand selectById(Integer id);

    void update(Brand brand);

    void delete(Integer id);

    void deletByIds(@Param("ids") int[] ids);


    List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);

    int selectTotalCount();

    int selectTotalCountXXX1(Brand brand);

    List<Brand> selectByConditions(@Param("brand") Brand brand,@Param("begin")int begin,@Param("size")int size);
}
