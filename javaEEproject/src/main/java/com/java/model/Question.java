package com.java.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/30 
//Time: 11:58
//To change this template use File | Settings | File Templates.
public class Question {
    private Integer question_id;//试题id
    private String question_content;//试题题干
    private String question_Aans;//A答案
    private String question_Bans;//B答案
    private String question_Cans;//C答案
    private String question_Dans;//D答案
    private String question_rightans;//正确答案
    private Integer question_type;//题目类型
    private Integer question_test;//题目对应试卷id

    public Question(Integer question_id, String question_content, String question_Aans,
                    String question_Bans, String question_Cans, String question_Dans, String question_rightans, Integer question_type, Integer question_test) {
        this.question_id = question_id;
        this.question_content = question_content;
        this.question_Aans = question_Aans;
        this.question_Bans = question_Bans;
        this.question_Cans = question_Cans;
        this.question_Dans = question_Dans;
        this.question_rightans = question_rightans;
        this.question_type = question_type;
        this.question_test = question_test;
    }

    public Question() {
    }

    public Integer getQuestion_test() {
        return question_test;
    }

    public void setQuestion_test(Integer question_test) {
        this.question_test = question_test;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getQuestion_Aans() {
        return question_Aans;
    }

    public void setQuestion_Aans(String question_Aans) {
        this.question_Aans = question_Aans;
    }

    public String getQuestion_Bans() {
        return question_Bans;
    }

    public void setQuestion_Bans(String question_Bans) {
        this.question_Bans = question_Bans;
    }

    public String getQuestion_Cans() {
        return question_Cans;
    }

    public void setQuestion_Cans(String question_Cans) {
        this.question_Cans = question_Cans;
    }

    public String getQuestion_Dans() {
        return question_Dans;
    }

    public void setQuestion_Dans(String question_Dans) {
        this.question_Dans = question_Dans;
    }

    public String getQuestion_rightans() {
        return question_rightans;
    }

    public void setQuestion_rightans(String question_rightans) {
        this.question_rightans = question_rightans;
    }

    public Integer getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(Integer question_type) {
        this.question_type = question_type;
    }
}
