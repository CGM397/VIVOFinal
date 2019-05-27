/*
 * This file was automatically generated by EvoSuite
 * Mon May 27 06:05:34 GMT 2019
 */

package edu.nju.vivofinal.statistics;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.nju.vivofinal.statistics.AverageScore;
import java.util.Date;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AverageScore_ESTest{

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      AverageScore averageScore0 = new AverageScore();
      averageScore0.setAverageScores((List<Double>) null);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      AverageScore averageScore0 = new AverageScore((List<Date>) null, (List<Double>) null);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      AverageScore averageScore0 = new AverageScore();
      averageScore0.setExamDate((List<Date>) null);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      AverageScore averageScore0 = new AverageScore();
      List<Double> list0 = averageScore0.getAverageScores();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      AverageScore averageScore0 = new AverageScore();
      List<Date> list0 = averageScore0.getExamDate();
      assertNull(list0);
  }
}