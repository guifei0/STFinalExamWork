package com.java.mapper;

import com.java.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMapperTest {
    @Autowired
    TestMapper testMapper;
    @Test
    public void selectAllTest() {
        List<com.java.model.Test> list=testMapper.selectAllTest();
        System.out.println(list);
    }

    @Test
    public void selectTest() {
        com.java.model.Test test=testMapper.selectTest(1);
        System.out.println(test);
    }

    @Test
    public void selectxzQuestionByTest() {
        List<com.java.model.Question> list=testMapper.selectxzQuestionByTest(1);
        System.out.println(list);
    }

    @Test
    public void selectpdQuestionByTest() {
        List<com.java.model.Question> list=testMapper.selectpdQuestionByTest(1);
        System.out.println(list);
    }

    @Test
    public void selectcxQuestionByTest() {
        List<com.java.model.Question> list=testMapper.selectcxQuestionByTest(1);
        System.out.println(list);
    }

    @Test
    public void selectQuestionByTest() {
        List<com.java.model.Question> list=testMapper.selectQuestionByTest(1);
        System.out.println(list);
    }

    @Test
    public void selectScoreByType() {
        int i=testMapper.selectScoreByType(1);
        System.out.println(i);
    }

    @Test
    public void changeTestName() {
        com.java.model.Test t = null;
        int i=testMapper.changeTestName(t);
        System.out.println(i);
    }

    @Test
    public void changeTestTime() {
        com.java.model.Test t = null;
        int i=testMapper.changeTestTime(t);
        System.out.println(i);
    }

    @Test
    public void changeQuestionAns() {
        Question q = null;
        int i=testMapper.changeQuestionAns(q);
        System.out.println(i);
    }

    @Test
    public void deleteQuestion() {
        int i=testMapper.deleteQuestion(1);
        System.out.println(i);
    }
    @Test
    public void deleteTest() {
        int i=testMapper.deleteTest(1);
        System.out.println(i);
    }

    @Test
    public void addQuestion() {
        Question q = null;
        int i=testMapper.addQuestion(q);
        System.out.println(i);

    }
}