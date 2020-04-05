package com.lagou.test;

import com.lagou.mapper.IMyUserMapper;

import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UsersTest {


    @Test
    public void addMyUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IMyUserMapper mapper = sqlSession.getMapper(IMyUserMapper.class);
        User user = new User();
        user.setId(7);
        user.setUsername("宋杰");
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectMyUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IMyUserMapper mapper = sqlSession.getMapper(IMyUserMapper.class);
        User user = new User();
        user.setId(1);
        User user1 = mapper.selectById(user);
        System.out.println(user1.getId()+":"+user1.getUsername());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateMyUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IMyUserMapper mapper = sqlSession.getMapper(IMyUserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("李华");
        mapper.updateById(user);
        System.out.println(user.getId()+":"+user.getUsername());
        sqlSession.commit();
        sqlSession.close();
    }

}




