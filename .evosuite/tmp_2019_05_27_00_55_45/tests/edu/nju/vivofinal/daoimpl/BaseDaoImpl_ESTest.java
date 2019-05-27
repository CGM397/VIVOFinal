/*
 * This file was automatically generated by EvoSuite
 * Sun May 26 16:59:18 GMT 2019
 */

package edu.nju.vivofinal.daoimpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.daoimpl.BaseDaoImpl;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class BaseDaoImpl_ESTest extends BaseDaoImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      boolean boolean0 = baseDaoImpl0.update((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      boolean boolean0 = baseDaoImpl0.save((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      Class<Object> class0 = Object.class;
      Object object0 = baseDaoImpl0.findById(class0, 1L);
      assertNull(object0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      Class<Object> class0 = Object.class;
      boolean boolean0 = baseDaoImpl0.delete(class0, (-1081L));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      // Undeclared exception!
      try { 
        baseDaoImpl0.getSession();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("edu.nju.vivofinal.daoimpl.BaseDaoImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      BaseDaoImpl baseDaoImpl0 = new BaseDaoImpl();
      Class<String> class0 = String.class;
      List list0 = baseDaoImpl0.getAllList(class0);
      assertNull(list0);
  }
}
