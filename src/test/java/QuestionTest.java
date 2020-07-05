import com.java.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/31 
//Time: 22:21
//To change this template use File | Settings | File Templates.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class QuestionTest {
    @Autowired
    TestService testService;
    @Test
    public void questionTest(){
        int i=testService.addQuestion2("static修饰抽象类，抽象方法","错");
        System.out.println(i);
    }

}

