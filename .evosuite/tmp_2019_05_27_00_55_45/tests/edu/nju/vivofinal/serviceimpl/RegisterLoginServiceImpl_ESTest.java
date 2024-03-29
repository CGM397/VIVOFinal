/*
 * This file was automatically generated by EvoSuite
 * Sun May 26 17:04:00 GMT 2019
 */

package edu.nju.vivofinal.serviceimpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.ExamScore;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.CommonService;
import edu.nju.vivofinal.serviceimpl.RegisterLoginServiceImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RegisterLoginServiceImpl_ESTest extends RegisterLoginServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(teacherInfoDao0).saveTeacherInfo(any(edu.nju.vivofinal.model.Teacher.class));
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      boolean boolean0 = registerLoginServiceImpl0.teacherRegister("%s: %s", "success");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Parent parent0 = new Parent("|", "|", "|", "|", "|", "|");
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(parent0).when(parentInfoDao0).findParentByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u5BB6\u957F", "$zl:4,66=", "p");
      assertEquals("wrong_password", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(teacherInfoDao0).saveTeacherInfo(any(edu.nju.vivofinal.model.Teacher.class));
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      boolean boolean0 = registerLoginServiceImpl0.teacherRegister("", "");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      doReturn("Properties must not be null!", (String) null).when(commonService0).generateRandomCode(anyInt());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ArrayList<Parent> arrayList0 = new ArrayList<Parent>();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(arrayList0, arrayList0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack0 = new Stack<Teacher>();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0, stack0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      registerLoginServiceImpl0.sendMail("\u9A8C\u8BC1\u7801 : ");
      String string0 = registerLoginServiceImpl0.sendMail("wrong_password");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      doReturn("").when(commonService0).generateRandomCode(anyInt());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Stack<Parent> stack0 = new Stack<Parent>();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.sendMail("wrong_password");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(true, false).when(parentInfoDao0).saveParentInfo(any(edu.nju.vivofinal.model.Parent.class));
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      boolean boolean0 = registerLoginServiceImpl0.parentRegister("UNKNOWN", "P ");
      boolean boolean1 = registerLoginServiceImpl0.parentRegister("&T", "");
      assertFalse(boolean1 == boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      // Undeclared exception!
      try { 
        registerLoginServiceImpl0.login((String) null, (String) null, "");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Stack<Parent> stack0 = new Stack<Parent>();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack1 = new Stack<Teacher>();
      Teacher teacher0 = new Teacher("hBpB&tj:Nl3`_Q0", ";j1ip1", "#L", "hBpB&tj:Nl3`_Q0", (Set<Parent>) null, (Set<ExamScore>) null);
      stack1.push(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack1).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.sendMail(";j1ip1");
      assertNotNull(string0);
      assertEquals("duplicate_mail", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      doReturn("jldm+").when(commonService0).generateRandomCode(anyInt());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Stack<Parent> stack0 = new Stack<Parent>();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack1 = new Stack<Teacher>();
      Teacher teacher0 = new Teacher("p", ";j1ip1", "#L", "p", (Set<Parent>) null, (Set<ExamScore>) null);
      stack1.push(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack1).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.sendMail(",g=bmW");
      assertEquals("jldm+", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Stack<Parent> stack0 = new Stack<Parent>();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack1 = new Stack<Teacher>();
      Teacher teacher0 = new Teacher();
      stack1.push(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack1).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      // Undeclared exception!
      try { 
        registerLoginServiceImpl0.sendMail(",g=bmW");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      LinkedList<Parent> linkedList0 = new LinkedList<Parent>();
      Parent parent0 = new Parent(")R`eE3pj8G;NWi;2a_", ")R`eE3pj8G;NWi;2a_", ")R`eE3pj8G;NWi;2a_", ")R`eE3pj8G;NWi;2a_", "l}9oo", ")R`eE3pj8G;NWi;2a_");
      linkedList0.add(parent0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack0 = new Stack<Teacher>();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.sendMail(")R`eE3pj8G;NWi;2a_");
      assertNotNull(string0);
      assertEquals("duplicate_mail", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      doReturn("\u6559\u5E08").when(commonService0).generateRandomCode(anyInt());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ArrayList<Parent> arrayList0 = new ArrayList<Parent>();
      Parent parent0 = new Parent("h(^)A", "h(^)A", "\u6559\u5E08", "\u6559\u5E08", "hBpB&tj:Nl3`_Q0", "success");
      arrayList0.add(parent0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(arrayList0).when(parentInfoDao0).findAllParents();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Stack<Teacher> stack0 = new Stack<Teacher>();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(stack0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.sendMail("\u6559\u5E08");
      assertEquals("\u6559\u5E08", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      HashSet<Parent> hashSet0 = new HashSet<Parent>();
      HashSet<ExamScore> hashSet1 = new HashSet<ExamScore>();
      Teacher teacher0 = new Teacher("P ", "P ", "G*5?4", "G*5?4", hashSet0, hashSet1);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u6559\u5E08", "wrong_password", "G*5?4");
      assertEquals("success", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      LinkedHashSet<Parent> linkedHashSet0 = new LinkedHashSet<Parent>();
      HashSet<ExamScore> hashSet0 = new HashSet<ExamScore>();
      Teacher teacher0 = new Teacher("8LN(h^1~T8", "%HcLd", "8LN(h^1~T8", "8LN(h^1~T8", linkedHashSet0, hashSet0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u6559\u5E08", "980231201@qq.com", "{q'OmpsD}EAZd2Y,lz>");
      assertEquals("wrong_password", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Teacher teacher0 = new Teacher();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u6559\u5E08", (String) null, "to=");
      assertEquals("wrong_password", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Parent parent0 = new Parent("|", "|", "|", "|", "|", "|");
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(parent0).when(parentInfoDao0).findParentByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u5BB6\u957F", "|", "|");
      assertEquals("success", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn((Parent) null).when(parentInfoDao0).findParentByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u5BB6\u957F", "\u5BB6\u957F", "\u5BB6\u957F");
      assertEquals("wrong_password", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      Teacher teacher0 = new Teacher();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u6559\u5E08", "w~n", "\u6559\u5E08");
      assertEquals("wrong_password", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      Parent parent0 = new Parent();
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(parent0).when(parentInfoDao0).findParentByMail(anyString());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u5BB6\u957F", "r)YVUWJE!6>/z{R", (String) null);
      assertNotNull(string0);
      assertEquals("wrong_password", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      RegisterLoginServiceImpl registerLoginServiceImpl0 = new RegisterLoginServiceImpl();
      CommonService commonService0 = mock(CommonService.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "commonService", (Object) commonService0);
      JavaMailSender javaMailSender0 = mock(JavaMailSender.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "mailSender", (Object) javaMailSender0);
      ParentInfoDao parentInfoDao0 = mock(ParentInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "parentInfoDao", (Object) parentInfoDao0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      Injector.inject(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(registerLoginServiceImpl0, (Class<?>) RegisterLoginServiceImpl.class);
      String string0 = registerLoginServiceImpl0.login("\u5BB6Q", "\u5BB6Q", "\u5BB6Q");
      assertEquals("", string0);
  }
}
