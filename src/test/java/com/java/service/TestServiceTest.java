package com.java.service;

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
public class TestServiceTest {
    @Autowired
    TestService testService;
    @Test
    public void selectAllTest() {
        List<com.java.model.Test> list=testService.selectAllTest();
        System.out.println(list);
    }


    @Test
    public void selectTotalscore() {
        int i=testService.selectTotalscore("1");
        System.out.println(i);
    }

    @Test
    public void selectxzQuestionByTest() {
        List<Question> i =testService.selectxzQuestionByTest("1");
        System.out.println(i);
    }

    @Test
    public void selectpdQuestionByTest() {
        List<Question> i =testService.selectpdQuestionByTest("1");
        System.out.println(i);
    }

    @Test
    public void selectcxQuestionByTest() {
        List<Question> i =testService.selectcxQuestionByTest("1");
        System.out.println(i);
    }
}