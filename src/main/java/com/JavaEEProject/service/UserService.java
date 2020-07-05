package com.JavaEEProject.service;

import com.JavaEEProject.mapper.UserMapper;
import com.JavaEEProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2020/6/28
//Time: 10:45
//To change this template use File | Settings | File Templates.
@Service
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**选择用户
     * @param id  传入用户id
     * @return  返回user对象
     */
    public User selectUser(String id){
        int userId=Integer.parseInt(id);
        User user=userMapper.selectUser(userId);
        return user;
    }

    /**
     * 插入user
     * @param name   用户名
     * @param password  密码
     * @param email  邮件
     */
    public void insertUser(String name,String password,String email) {
        User user = new User();
        user.setUserName(name);
        user.setUserPassword(password);
        user.setUserPostbox(email);
        userMapper.insertUser(user);
    }

    /**
     * @param name  插入管理者
     * @param password  插入密码
     * @param email  插入邮箱
     */
    public void insertManager(String name,String password,String email){
        User user = new User();
        user.setUserName(name);
        user.setUserPassword(password);
        user.setUserPostbox(email);
        user.setUserType(1);
        userMapper.insertUser(user);
    }

    /**
     * @param id   用户id，通过用户id删除
     */
    public void deleteUser(String id){
        int userId=Integer.parseInt(id);
        userMapper.deleteUser(userId);
    }

    /**
     * @param id  改变用户id
     * @param name  改变用户姓名
     * @param password   密码
     * @param post   提交
     * @param phone  手机
     * @param wish  愿望
     */
    public void changeUser(String id,String name,String password,String post,String phone,String wish){
        int userId=Integer.parseInt(id);
        User user=new User(userId,name,password,post,phone,wish);
        userMapper.changeUser(user);
    }

    /**
     * @return   选择所用用户
     */
    public List<User> selectAll(){
        List<User> list=userMapper.selectAll();
        return list;
    }

    /**
     * @param wish  愿望
     * @param id    用户id
     */
    public void changeWish(String wish,String id){
        int userId=Integer.parseInt(id);
        User user=new User();
        user.setUserWish(wish);
        user.setUserId(userId);
        userMapper.changeWish(user);
    }
}
