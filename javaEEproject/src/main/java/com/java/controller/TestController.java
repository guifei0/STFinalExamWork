package com.java.controller;

import com.java.model.Question;
import com.java.model.Test;
import com.java.model.User;
import com.java.service.TestService;
import com.java.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/29
//Time: 20:52
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("Test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;

    public TestController() {
    }

    /*
    查询所有试卷
     */
    @RequestMapping("selectAllTest")
    @ResponseBody
    public JSONObject selectAllTest(){
//        System.out.println(pagenum);
        List<Test> list=testService.selectAllTest();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("list",list);
        return jsonObject;
    }
    /*
    点击开始考试
     */
    @RequestMapping("startTest")
    public String startTest(HttpServletRequest request, Model model){
        String testid=request.getParameter("testid");
        String userid=request.getParameter("userid");
        List<Question> qxzlist=testService.selectxzQuestionByTest(testid);
        List<Question> qpdlist=testService.selectpdQuestionByTest(testid);
        List<Question> qcxlist=testService.selectcxQuestionByTest(testid);
        int score=testService.selectTotalscore(testid);
        Test test=testService.selectTest(testid);
        User user=userService.selectUser(userid);
        model.addAttribute("qxzlist",qxzlist);
        model.addAttribute("qpdlist",qpdlist);
        model.addAttribute("qcxlist",qcxlist);
        model.addAttribute("score",score);
        model.addAttribute("user",user);
        model.addAttribute("test",test);
        return "starttest";
    }
    /*
    计算分数
     */
    @RequestMapping("calculateGrades")
    @ResponseBody
    public JSONObject calculateGrades(@RequestParam("ansArr") String ansArr, @RequestParam("qidArr")String qidArr){
        JSONObject jsonObject=new JSONObject();
        //json字符串转String数组
        JSONArray array = JSONArray.fromObject(ansArr);
        JSONArray array1 = JSONArray.fromObject(qidArr);
        List ansarray =(ArrayList)JSONArray.toCollection(array, HashMap.class);
        List qidarray =(ArrayList)JSONArray.toCollection(array1, HashMap.class);

        int grades=testService.calculateGrades(ansarray,qidarray);
        jsonObject.put("score",grades);
        return jsonObject;
    }

    /*
    删除试卷
     */
    @RequestMapping("deleteTest")
    public String deleteTest(HttpServletRequest request, Model model){
        String testid=request.getParameter("testid");
        String userid=request.getParameter("userid");
        testService.deleteTest(testid);
        model.addAttribute("userid",userid);
        return "teacherMain";
    }
    /*
    添加试题
     */
    @RequestMapping("addQuestion")
    @ResponseBody
    public JSONObject addQuestion(String content,String Aans,String Bans,String Cans,String Dans,String rightAns){
        JSONObject jsonObject=new JSONObject();
        testService.addQuestion1(content, Aans, Bans, Cans, Dans, rightAns);
        return jsonObject;
    }

    /*
    查看试卷
     */
    @RequestMapping("selectQuestionByTest")
    public String selectQuestionByTest(HttpServletRequest request, Model model){
        String testid=request.getParameter("testid");
        String userid=request.getParameter("userid");
        List<Question> qxzlist=testService.selectxzQuestionByTest(testid);
        List<Question> qpdlist=testService.selectpdQuestionByTest(testid);
        List<Question> qcxlist=testService.selectcxQuestionByTest(testid);
        int score=testService.selectTotalscore(testid);
        Test test=testService.selectTest(testid);
        model.addAttribute("qxzlist",qxzlist);
        model.addAttribute("qpdlist",qpdlist);
        model.addAttribute("qcxlist",qcxlist);
        model.addAttribute("score",score);
        model.addAttribute("test",test);
        model.addAttribute("userid",userid);
        return "TestQuestion";
    }
    /*
    修改试卷名称
     */
    @RequestMapping("changeTestName")
    @ResponseBody
    public JSONObject changeTestName(String testid,String str){
        JSONObject jsonObject=new JSONObject();
        int i=testService.changeTestName(testid,str);
        jsonObject.put("isSuccess",i);
        return jsonObject;
    }
    /*
    修改试卷时间
     */
    @RequestMapping("changeTestTime")
    @ResponseBody
    public JSONObject changeTestTime(String testid,String str){
        JSONObject jsonObject=new JSONObject();
        int i=testService.changeTestTime(testid,str);
        jsonObject.put("isSuccess",i);
        return jsonObject;
    }
    /*
    修改题目答案
     */
    @RequestMapping("changeQuestionAns")
    @ResponseBody
    public JSONObject changeQuestionAns(String questionid,String str){
        JSONObject jsonObject=new JSONObject();
        int i=testService.changeQuestionAns(questionid,str);
        jsonObject.put("isSuccess",i);
        return jsonObject;
    }
    /*
    删除题目
     */
    @RequestMapping("deleteQuestion")
    @ResponseBody
    public JSONObject deleteQuestion(String questionid){
        JSONObject jsonObject=new JSONObject();
        int i=testService.deleteQuestion(questionid);
        jsonObject.put("isSuccess",i);
        return jsonObject;
    }
}
