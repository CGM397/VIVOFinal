/*
 * This file was automatically generated by EvoSuite
 * Sun May 26 17:17:19 GMT 2019
 */

package edu.nju.vivofinal.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.controller.RegisterLoginController;
import edu.nju.vivofinal.service.RegisterLoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterLoginController_ESTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(registerLoginService0).teacherRegister(anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      boolean boolean0 = registerLoginController0.teacherRegister((String) null, "EX!?T5");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(registerLoginService0).sendMail(anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      String string0 = registerLoginController0.sendMail("?DP|6 X~Liu^");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn("").when(registerLoginService0).sendMail(anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      String string0 = registerLoginController0.sendMail("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(registerLoginService0).parentRegister(anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      boolean boolean0 = registerLoginController0.parentRegister((String) null, "");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn("").when(registerLoginService0).login(anyString() , anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
      String string0 = registerLoginController0.login("success", "X;i=+l8yn", "\"|s<2,h#5cQ|", httpServletRequest0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      // Undeclared exception!
      try { 
        registerLoginController0.logout((HttpServletRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("edu.nju.vivofinal.controller.RegisterLoginController", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn("success").when(registerLoginService0).login(anyString() , anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn((HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
      // Undeclared exception!
      try { 
        registerLoginController0.login("#LapRZ2^|qZ3q{_pl;.", "", "", httpServletRequest0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("edu.nju.vivofinal.controller.RegisterLoginController", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
      boolean boolean0 = registerLoginController0.logout(httpServletRequest0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn((HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
      boolean boolean0 = registerLoginController0.logout(httpServletRequest0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn("success").when(registerLoginService0).login(anyString() , anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
      String string0 = registerLoginController0.login("[{T<n{y{d/~", "[{T<n{y{d/~", "", httpServletRequest0);
      assertEquals("success", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn("zF]p~Mn;?fs:N?").when(registerLoginService0).sendMail(anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      String string0 = registerLoginController0.sendMail("?DP|6 X~Liu^");
      assertEquals("zF]p~Mn;?fs:N?", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(registerLoginService0).teacherRegister(anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      boolean boolean0 = registerLoginController0.teacherRegister("|L{", "");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      RegisterLoginController registerLoginController0 = new RegisterLoginController();
      RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(registerLoginService0).parentRegister(anyString() , anyString());
      Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
      Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
      boolean boolean0 = registerLoginController0.parentRegister("KJlpoQ", "su3cess");
      assertTrue(boolean0);
  }
}