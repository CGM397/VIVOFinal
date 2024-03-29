/*
 * This file was automatically generated by EvoSuite
 * Sun May 26 17:09:43 GMT 2019
 */

package edu.nju.vivofinal.serviceimpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.ExamScore;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.serviceimpl.TeacherInfoServiceImpl;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class TeacherInfoServiceImpl_ESTest extends TeacherInfoServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn((Teacher) null).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher0 = teacherInfoServiceImpl0.findTeacherInfoByMail("");
      assertNull(teacher0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedHashSet<ExamScore> linkedHashSet0 = new LinkedHashSet<ExamScore>();
      Teacher teacher0 = new Teacher("<&0qc$$9", "edu.nju.vivofinal.serviceimpl.TeacherInfoServiceImpl", "+I", (String) null, (Set<Parent>) null, linkedHashSet0);
      teacher0.setTeacherId(3726L);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherInfoByMail("");
      assertNull(teacher1.getTeacherPhoneNumber());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      Teacher teacher0 = new Teacher();
      teacher0.setTeacherId((-1790L));
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherInfoByMail("");
      assertNull(teacher1.getTeacherPhoneNumber());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      TreeSet<Parent> treeSet0 = new TreeSet<Parent>();
      LinkedHashSet<ExamScore> linkedHashSet0 = new LinkedHashSet<ExamScore>();
      Teacher teacher0 = new Teacher("UNSORTED", "UNSORTED", "UNSORTED", "yNt/a<}BVcf[~7JBjfG", treeSet0, linkedHashSet0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(teacher0).when(teacherInfoDao0).findTeacherByMail(anyString());
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherInfoByMail("UNSORTED");
      assertEquals("UNSORTED", teacher1.getTeacherName());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      HashSet<Parent> hashSet0 = new HashSet<Parent>();
      teacher0.setTeacherId(901L);
      Parent parent0 = new Parent("UNSORTED", "UNSORTED", "l~|])ole~Ut#N)n", "UNSORTED", "UNSORTED", "UNSORTED");
      hashSet0.add(parent0);
      teacher0.setParents(hashSet0);
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("UNSORTED");
      assertNull(teacher1.getTeacherMail());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      HashSet<Parent> hashSet0 = new HashSet<Parent>();
      teacher0.setTeacherId((-15L));
      Parent parent0 = new Parent("UNSORTED", "UNSORTED", "l~|])ole~Ut#N)n", "UNSORTED", "UNSORTED", "Iterable must not be null!");
      hashSet0.add(parent0);
      teacher0.setParents(hashSet0);
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("UNSORTED");
      assertSame(teacher1, teacher0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      HashSet<Parent> hashSet0 = new HashSet<Parent>();
      Parent parent0 = new Parent("KIl>wDz", "KIl>wDz", "l~|])ole~Ut#N)n", "KIl>wDz", "KIl>wDz", "KIl>wDz");
      teacher0.setTeacherPhoneNumber(";4Y]WGJE/V");
      hashSet0.add(parent0);
      teacher0.setParents(hashSet0);
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("KIl>wDz");
      assertNull(teacher1.getTeacherPassword());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0, (List) null).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      teacherInfoServiceImpl0.findTeacherByParentMail("I$RUF@|zI");
      // Undeclared exception!
      try { 
        teacherInfoServiceImpl0.findTeacherByParentMail("UNSORTED");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("edu.nju.vivofinal.serviceimpl.TeacherInfoServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      LinkedHashSet<Parent> linkedHashSet0 = new LinkedHashSet<Parent>();
      Parent parent0 = new Parent("U4SORTED", "U4SORTED", "U4SORTED", "U4SORTED", "U4SORTED", "U4SORTED");
      linkedHashSet0.add(parent0);
      teacher0.setParents(linkedHashSet0);
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("UNSORTED");
      assertNull(teacher1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      LinkedHashSet<Parent> linkedHashSet0 = new LinkedHashSet<Parent>();
      teacher0.setParents(linkedHashSet0);
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("U4SORTED");
      assertNull(teacher1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      LinkedList<Teacher> linkedList0 = new LinkedList<Teacher>();
      Teacher teacher0 = new Teacher();
      linkedList0.add(teacher0);
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(teacherInfoDao0).findAllTeachers();
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      Teacher teacher1 = teacherInfoServiceImpl0.findTeacherByParentMail("U4SORTED");
      assertNull(teacher1);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TeacherInfoServiceImpl teacherInfoServiceImpl0 = new TeacherInfoServiceImpl();
      Teacher teacher0 = new Teacher();
      TeacherInfoDao teacherInfoDao0 = mock(TeacherInfoDao.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(teacherInfoDao0).updateTeacherInfo(any(edu.nju.vivofinal.model.Teacher.class));
      Injector.inject(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class, "teacherInfoDao", (Object) teacherInfoDao0);
      Injector.validateBean(teacherInfoServiceImpl0, (Class<?>) TeacherInfoServiceImpl.class);
      teacherInfoServiceImpl0.updateTeacherInfo(teacher0);
      assertNull(teacher0.getTeacherName());
  }
}
