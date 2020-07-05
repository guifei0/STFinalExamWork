package com.java.controller;


import com.java.model.User;
import com.java.service.UserService;
import com.java.util.MD5;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/5 
//Time: 20:04
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {}
    //登录
    @RequestMapping(value = "Login")
    @ResponseBody
    public JSONObject login(String name, String password)  {
        String passwordByMd5 = MD5.MD5(password);
        JSONObject jsonObject=new JSONObject();
        String word;
        if (name == "") {
            word = "请填写用户名";
            jsonObject.put("woord",word);
            return jsonObject;
        }
        if (passwordByMd5 == "") {
            word = "请输入密码";
            jsonObject.put("woord",word);
            return jsonObject;
        }
        //判断登录名和密码
        List<User> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUser_name().equals(name)) {
                if (list.get(i).getUser_password().equals(passwordByMd5)) {
                    word = "12306";
                    String userid=String.valueOf(list.get(i).getUser_id());
                    jsonObject.put("userid",userid);
                    jsonObject.put("woord",word);
                    return jsonObject;
                } else {
                    word = "密码输入有误，请重新输入";
                    jsonObject.put("woord",word);
                    return jsonObject;
                }
            }
        }
        word = "用户不存在";
        jsonObject.put("woord",word);
        return jsonObject;
    }
    //注册
    @RequestMapping("Register")
    @ResponseBody
    public JSONObject insertUser(String name,String password) {
        JSONObject jsonObject=new JSONObject();
        String word="";
        if (password == "") {
            word="密码不能为空";
            jsonObject.put("woord",word);
            return jsonObject;
        }
        if(name==""){
            word="用户名不能为空";
            jsonObject.put("woord",word);
            return jsonObject;
        }
        String passwordByMd5 = MD5.MD5(password);
        //判断是否注册过
        List<User> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUser_name().equals(name)) {
                word="用户名已被使用";
                jsonObject.put("woord",word);
                return jsonObject;
            }
        }
        word="注册成功";
        int i= userService.insertUser(name,passwordByMd5);
        jsonObject.put("woord",word);
        return jsonObject;
    }
    //主页
    @RequestMapping("toMain")
    public String Main(HttpServletRequest request, Model model){
        String userId = request.getParameter("userid");
        User user = this.userService.selectUser(userId);

        model.addAttribute("userid", userId);
        if (user.getUser_type()==1){
            return "studentMain";
        }else{
            return "teacherMain";
        }

    }




}
