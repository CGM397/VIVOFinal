/*
 * This file was automatically generated by EvoSuite
 * Mon May 27 06:09:14 GMT 2019
 */

package edu.nju.vivofinal.statistics;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.nju.vivofinal.statistics.StudentScore;
import java.util.Date;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentScore_ESTest{

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      StudentScore studentScore0 = new StudentScore();
      List<Double> list0 = studentScore0.getScores();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      StudentScore studentScore0 = new StudentScore();
      studentScore0.setExamDate((List<Date>) null);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      StudentScore studentScore0 = new StudentScore();
      studentScore0.setScores((List<Double>) null);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      StudentScore studentScore0 = new StudentScore();
      List<Date> list0 = studentScore0.getExamDate();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      StudentScore studentScore0 = new StudentScore((List<Date>) null, (List<Double>) null);
  }
}
