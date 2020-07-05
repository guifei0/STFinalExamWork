package com.java.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/30 
//Time: 0:09
//To change this template use File | Settings | File Templates.

/*
试卷实体类
 */
public class Test {
    private Integer test_id;//试卷id
    private String test_name;//试卷名称
    private Integer test_time;//试卷时长
    private Integer test_question_id;//试卷题目表id

    public Test(int test_id, String test_name, int test_time, int test_question_id) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.test_time = test_time;
        this.test_question_id = test_question_id;
    }

    public Test() {
    }

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public Integer getTest_time() {
        return test_time;
    }

    public void setTest_time(Integer test_time) {
        this.test_time = test_time;
    }

    public Integer getTest_question_id() {
        return test_question_id;
    }

    public void setTest_question_id(Integer test_question_id) {
        this.test_question_id = test_question_id;
    }
}
