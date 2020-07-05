package com.java.mapper;

import com.java.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void selectAll() {
        List<com.java.model.User> list=userMapper.selectAll();
        System.out.println(list);
    }

    @Test
    public void insertUser() {
        User u=new User();
        u.setUser_id(2);
        u.setUser_name("chen");
        u.setUser_password("123456");
        u.setUser_type(1);
        int i=userMapper.insertUser(u);
        System.out.println(i);
    }

    @Test
    public void selectUser() {
        User u=userMapper.selectUser(1);
        System.out.println(u);
    }
}