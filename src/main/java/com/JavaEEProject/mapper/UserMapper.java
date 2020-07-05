package com.JavaEEProject.mapper;

import com.JavaEEProject.model.User;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2020/6/28
//Time: 10:35
//To change this template
// use File | Settings | File Templates.
public interface UserMapper {
    /** 按照id查找用户
     * @param id 用户的id
     * @return User
     */
    User selectUser(int id);

    /** 注册一个新用户
     * @param user User类型的用户
     */
    void insertUser(User user);

    /** 按照id删除用户
     * @param id 所要删除用户的id
     */
    void deleteUser(int id);

    /** 修改用户信息
     * @param user 用户
     */
    void changeUser(User user);

    List<User> selectAll();

    /** 修改用户的愿望
     * @param user 用户
     */
    void changeWish(User user);
}
