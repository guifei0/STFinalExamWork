package com.JavaEEProject.controller;

import com.JavaEEProject.model.User;
import com.JavaEEProject.service.UserService;
import com.JavaEEProject.util.MD5;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2020/6/28
//Time: 14:12
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {}

    /** 修改用户信息
     * @param str 修改的内容：String
     * @param id 用户的id
     * @param flag 操作的选项：1. 修改电话 2. 修改邮箱 3. 修改密码 4. 修改愿望
     * @return 返回修改成功的信息
     * @throws UnsupportedEncodingException 编码异常
     */
    //修改用户个人信息
    @RequestMapping("changeUser")
    @ResponseBody
    public JSONObject changeUser(String str,String id,String flag) throws UnsupportedEncodingException {
        str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        int f=Integer.parseInt(flag);
        JSONObject jsonObject=new JSONObject();
        User user=userService.selectUser(id);
        switch (f){
            case 1://修改电话
                userService.changeUser(id,user.getUserName(),user.getUserPassword(),user.getUserPostbox(),str,user.getUserWish());
                break;
            case 2://修改邮箱
                userService.changeUser(id,user.getUserName(), user.getUserPassword(),str,user.getUserPhone(),user.getUserWish());
                break;
            case 3://修改密码
                userService.changeUser(id,user.getUserName(),str,user.getUserPostbox(),user.getUserPhone(),user.getUserWish());
                break;
            case 4://修改愿望
                userService.changeUser(id,user.getUserName(),MD5.MD5(user.getUserPassword()),user.getUserPostbox(),user.getUserPhone(),str);
                break;
        }
        jsonObject.put("word","修改成功");
        return jsonObject;
    }

    /** 注册一个用户
     * @param name 用户的名字
     * @param password 用户的密码
     * @param email 用户的邮箱
     * @return 返回注册结果信息
     */
    //注册
    @RequestMapping("Register")
    @ResponseBody
    public JSONObject insertUser(String name,String password,String email) {
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
            if (list.get(i).getUserName().equals(name)) {
                word="用户名已被使用";
                jsonObject.put("woord",word);
                return jsonObject;
            }
        }
        word="注册成功";
        userService.insertUser(name,passwordByMd5,email);
        jsonObject.put("woord",word);
        return jsonObject;
    }

    /** 用户登录
     * @param name 用户的名称
     * @param password 用户的密码
     * @return 返回登录结果的信息：成功或者失败
     */
    //登录
    @RequestMapping("Login")
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
            if (list.get(i).getUserName().equals(name)) {
                if (list.get(i).getUserPassword().equals(passwordByMd5)) {
                    word = "12306";
                    String userid=String.valueOf(list.get(i).getUserId());
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

    /** 注册管理员
     * @param name 管理员的名称
     * @param password 管理员的密码
     * @param email 管理员的邮箱
     * @return 返回注册结果的信息
     */
    //管理员注册
    @RequestMapping("RegisterManager")
    @ResponseBody
    public JSONObject insertManager(String name,String password,String email) {
        String passwordByMd5 = MD5.MD5(password);
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
        //判断是否注册过
        List<User> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(name)) {
                word="用户名已被使用";
                jsonObject.put("woord",word);
                return jsonObject;
            }
        }
        word="注册成功";
        userService.insertManager(name,passwordByMd5,email);
        jsonObject.put("woord",word);
        return jsonObject;
    }

    /** 管理员登录
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return 返回管理员登录结果的信息
     */
    //管理员登录
    @RequestMapping("loginManager")
    @ResponseBody
    public JSONObject loginManager(String name, String password)  {
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
            if (list.get(i).getUserName().equals(name)) {
                if (list.get(i).getUserPassword().equals(passwordByMd5)) {
                    String userid=String.valueOf(list.get(i).getUserId());
                    int usertype=list.get(i).getUserType();
                    if(usertype==0){
                        word="您不是管理员";
                        jsonObject.put("woord",word);
                        return jsonObject;
                    }else{
                        word = "12306";
                        jsonObject.put("userid",userid);
                        jsonObject.put("woord",word);
                        return jsonObject;
                    }
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

    /** 主页
     * @param request HttpRequest请求
     * @param model Model
     * @return 返回Main.jsp这个视图
     */
    //主页
    @RequestMapping("Main")
    public String showUser(HttpServletRequest request, Model model) {
        //调用service中的方法
        String userId = request.getParameter("userid");
        User user = this.userService.selectUser(userId);
        //将信息保存传给前台
        model.addAttribute("user", user);
        //返回一个Main.jsp这个视图
        return "Main";
    }
    //提供所有user_wish不为空的用户给主页
    @RequestMapping("showAllWishes")
    @ResponseBody
    public Map<String,Object> showAllWishes(){
        List<User> list= userService.selectAll();
        List<User> list1=new ArrayList<User>();
        for (int i=0;i<list.size();i++){
            if (list.get(i).getUserWish()!=null){
                list1.add(list.get(i));
            }
        }//将数据库中愿望不为空的用户重新保存在一个list中
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list",list1);
        return map;//将list存在map中提交
    }

    /** 提供所有用户信息给管理界面
     * @param pageNum 用户信息
     * @return 返回一个Map
     */
    //提供所有用户信息给管理界面
    @RequestMapping("showAllUsers")
    @ResponseBody
    public Map<String,Object> showAllUsers(String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=5;//每页条数
        List<User> list= userService.selectAll();
        List<User> list1=new ArrayList<User>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pages",N);
        return map;
    }

    /** 删除用户
     * @param userid 用户的id
     * @return 返回删除的信息
     */
    //删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public JSONObject deleteUser(String userid) {
        userService.deleteUser(userid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",1);
        return jsonObject;
    }

    /** 添加愿望
     * @param str 所要添加的愿望
     * @param id 用户的id
     * @return 添加后的信息
     * @throws UnsupportedEncodingException 编码异常
     */
    @RequestMapping("addWish")
    @ResponseBody
    public JSONObject addwish( String str, String id) throws UnsupportedEncodingException {
        str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
//      System.out.println("str: "+str+"id: "+id);
        JSONObject jsonObject=new JSONObject();
        int json;
        User user=userService.selectUser(id);
        if(user.getUserWish()!=null){
            json=1;
        }else {
            userService.changeWish(str,id);
            json=2;
        }
        jsonObject.put("json",json);
        return jsonObject;
    }

    /** 个人管理(点击主页I时跳入个人管理界面（对管理员和用户都有效）)
     * @param request HttpRequest请求
     * @param model Model
     * @return String: "Manager"or "Admin"
     */
    //个人管理(点击主页I时跳入个人管理界面（对管理员和用户都有效）)
    @RequestMapping("toAdmin")
    public String toadmin(HttpServletRequest request,Model model){
        User user=userService.selectUser(request.getParameter("userid"));
        int type=user.getUserType();
        model.addAttribute("user",user);
        if(type==1){
            return "Manager";
        }
        return "Admin";
    }

    /** 返回登录String
     * @return String: "Login"
     */
    //返回登录(用作注册成功时返回登陆界面)
    @RequestMapping("toLogin")
    public String tologin(){
        return "Login";
    }

    /** 返回登录管理String
     * @return String: "ManagerLogin"
     */
    @RequestMapping("toLoginManager")
    public String loginmanager(){
        return "ManagerLogin";
    }
//    //SelfDefineInvalidCharacterFilter：过滤request请求中的非法字符，防止脚本攻击
//    public class InvalidCharacterFilter implements Filter {
//
//        public void destroy() {
//
//        }
//
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//            String parameterName = null;
//            String parameterValue = null;
//            // 获取请求的参数
//            //Enumeration<String> allParameter = request.getParameterNames();
//            //while(allParameter.hasMoreElements()){
//            //parameterName = allParameter.nextElement();
//            parameterValue =  request.getParameter("talk");
//            System.out.println(parameterValue+"传值");
//            boolean ok=true;
//            if(null != parameterValue){
//                for(String str : invalidCharacter){
//                    if (StringUtils.containsIgnoreCase(parameterValue, str)){
//                        JSONObject obj = new JSONObject();
//                        obj.put("isFalse",0);
//                        response.getWriter().print(obj.toString());
//                        ok=false;
//                    }
//                }
//                if(ok)filterChain.doFilter(request, response); // 执行目标资源，放行
//            }
//
//            else{
//                filterChain.doFilter(request, response); // 执行目标资源，放行
//            }
//        }
//        public void init(FilterConfig filterConfig) throws ServletException {
//
//        }
//        // 需要过滤的非法字符
//        private String[] invalidCharacter = new String[]{
//                "rnm","ctm","fuck","shit","cnm","rtm","nmsl","日妈","哈麻批","宝批龙","哈麻批","我靠","我草","我艹","我日"
//        };
//    }
}