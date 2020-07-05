package com.java.mapper;

import com.java.model.User;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/5 
//Time: 20:05
//To change this template use File | Settings | File Templates.
public interface UserMapper {
    List<User> selectAll();
    int insertUser(User user);
    User selectUser(Integer userid);
}
