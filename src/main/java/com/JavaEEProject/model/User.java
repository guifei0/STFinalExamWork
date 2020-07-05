package com.JavaEEProject.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2020/6/28
//Time: 10:30
//To change this template use File | Settings | File Templates.
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPostbox;
    private String userPhone;
    private String userWish;
    private int userType;


    public User() {
        super();
    }

    /**
     * @param userId   初始化用户id
     * @param userName   用户和姓名
     * @param userPassword   用户密码
     * @param userPostbox   用户提交box
     * @param userPhone    用户电话
     * @param userWish      用户愿望
     */
    public User(int userId,String userName,String userPassword,String userPostbox,String userPhone,String userWish){
        this.userId=userId;
        this.userName=userName;
        this.userPassword=userPassword;
        this.userPhone=userPhone;
        this.userPostbox=userPostbox;
        this.userWish=userWish;
    }

    /**
     * @return  增加用户类型
     */
    public int getUserType() {
        return userType;
    }

    /**
     * @param userType  增加用户类型
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * @return  增加用户愿望
     */
    public String getUserWish() {
        return userWish;
    }

    /**
     * @param userWish  增加用户
     */
    public void setUserWish(String userWish) {
        this.userWish = userWish;
    }

    /**
     * @return 获得用户id
     */
    public int getUserId() { return userId;
    }

    /**
     * @param userId  用户id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return  获取用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName  设置用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return  获得用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword   设置用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return   获得用户提交手册
     */
    public String getUserPostbox() {
        return userPostbox;
    }

    /**
     * @param userPostbox  设置用户手册
     */
    public void setUserPostbox(String userPostbox) {
        this.userPostbox = userPostbox;
    }

    /**
     * @return  获得用户手机
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone  设置用户手机
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
