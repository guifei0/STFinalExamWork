package com.java.service;

import com.java.mapper.TestMapper;
import com.java.model.Question;
import com.java.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/29 
//Time: 20:52
//To change this template use File | Settings | File Templates.
@Service
@Component
public class TestService {
    @Autowired
    private TestMapper testMapper;

    //查询所有试卷
    public List<Test> selectAllTest(){
        List<Test> list=testMapper.selectAllTest();
        return list;
    }
    //查询一张试卷
    public Test selectTest(String testid){
        return testMapper.selectTest(Integer.valueOf(testid));
    }
    //查询试卷总分
    public int selectTotalscore(String testid){
        //先查询试卷中所有试题
        List<Question> list=testMapper.selectQuestionByTest(Integer.parseInt(testid));
        int score=0;
        for (int i=0;i<list.size();i++){
            int t=list.get(i).getQuestion_type();
            if (t==1||t==4){
                score+=2;
            }else if (t==2){
                score+=1;
            }else if (t==3){
                score+=3;
            }
        }
        return score;
    }
    //根据试卷id查询试题(选择)
    public List<Question> selectxzQuestionByTest(String testid){
        List<Question> list=testMapper.selectxzQuestionByTest(Integer.parseInt(testid));
        return list;
    }

    //根据试卷id查询试题(判断)
    public List<Question> selectpdQuestionByTest(String testid){
        List<Question> list=testMapper.selectpdQuestionByTest(Integer.parseInt(testid));
        return list;
    }
    //根据试卷id查询试题(选择)
    public List<Question> selectcxQuestionByTest(String testid){
        List<Question> list=testMapper.selectcxQuestionByTest(Integer.parseInt(testid));
        return list;
    }


    //计算分数
    public int calculateGrades(List<String> ansArr,List<String> qidarr){
        int grades=0;
        for (int i=0;i<ansArr.size();i++){
            int qid= Integer.parseInt(qidarr.get(i));
            if (ansArr.get(i).equals(testMapper.selectRightAns(qid))){
                grades+=testMapper.selectScoreByType(qid);
            }
        }
        return grades;
    }
    //修改试卷名
    public int changeTestName(String testid,String str){
        Test test=new Test();
        test.setTest_id(Integer.valueOf(testid));
        test.setTest_name(str);
        return testMapper.changeTestName(test);
    }
    //修改试卷时间
    public int changeTestTime(String testid,String str){
        Test test=new Test();
        test.setTest_id(Integer.valueOf(testid));
        test.setTest_time(Integer.valueOf(str));
        return testMapper.changeTestTime(test);
    }
    //修改试题答案
    public int changeQuestionAns(String id,String str){
        Question question=new Question();
        question.setQuestion_id(Integer.valueOf(id));
        question.setQuestion_rightans(str);
        return testMapper.changeQuestionAns(question);
    }
    //删除试题
    public int deleteQuestion(String questionid) {
        return testMapper.deleteQuestion(Integer.parseInt(questionid));
    }
    //删除试卷
    public int deleteTest(String testid){
        return testMapper.deleteTest(Integer.parseInt(testid));
    }
    //添加试题(选择题)
    public int addQuestion1(String content,String Aans,String Bans,String Cans,String Dans,String rightAns){
        Question question=new Question();
        question.setQuestion_content(content);
        question.setQuestion_Aans(Aans);
        question.setQuestion_Bans(Bans);
        question.setQuestion_Cans(Cans);
        question.setQuestion_Dans(Dans);
        question.setQuestion_rightans(rightAns);
        question.setQuestion_type(1);
        return testMapper.addQuestion(question);
    }
    //添加试题(判断题)
    public int addQuestion2(String content,String rightAns){
        Question question=new Question();
        question.setQuestion_content(content);
        question.setQuestion_rightans(rightAns);
        question.setQuestion_type(2);
        return testMapper.addQuestion(question);
    }
    //添加试题(读程序题)
    public int addQuestion3(String content,String rightAns){
        Question question=new Question();
        question.setQuestion_content(content);
        question.setQuestion_rightans(rightAns);
        question.setQuestion_type(3);
        return testMapper.addQuestion(question);
    }
    //添加试题(填空题)
    public int addQuestion4(String content,String rightAns){
        Question question=new Question();
        question.setQuestion_content(content);
        question.setQuestion_rightans(rightAns);
        question.setQuestion_type(4);
        return testMapper.addQuestion(question);
    }


}

