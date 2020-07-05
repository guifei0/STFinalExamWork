package com.java.service;

import com.java.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void selectAll() {
        List<com.java.model.User> list=userService.selectAll();
        System.out.println(list);
    }

    @Test
    public void insertUser() {
        int i=userService.insertUser("chen","123456");
        System.out.println("ssss");
        System.out.println(i);
    }

    @Test
    public void selectUser() {
        User u=userService.selectUser("1");
        System.out.println(u);
    }
}