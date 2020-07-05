package com.java.service;

import com.java.mapper.UserMapper;
import com.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/5 
//Time: 20:06
//To change this template use File | Settings | File Templates.
@Service
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        List<User> list=userMapper.selectAll();
        return list;
    }

    public int insertUser(String name,String password){
        User user = new User();
        user.setUser_name(name);
        user.setUser_password(password);
        return userMapper.insertUser(user);
    }
    public User selectUser(String userid){
        User user=userMapper.selectUser(Integer.valueOf(userid));
        return user;
    }
}
