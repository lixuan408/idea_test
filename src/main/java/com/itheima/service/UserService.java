package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(username, password);


        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.selectByUsername(user.getUsername());
        if (user1 != null) {
            //用户名已经存在

            sqlSession.close();
            return false;
        } else {
            //用户名不存在
            userMapper.add(user);

            sqlSession.commit();
            sqlSession.close();
            return true;
        }
    }

    public boolean checkUsername(String username ) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByUsername(username);
        if (user!= null) {
            //用户名已经存在

            sqlSession.close();
            return false;
        } else {
            //用户名不存在
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
    }
}



