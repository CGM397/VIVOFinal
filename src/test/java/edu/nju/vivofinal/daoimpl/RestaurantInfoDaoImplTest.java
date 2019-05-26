/*
 * This file was automatically generated by EvoSuite
 * Sat May 25 16:25:34 GMT 2019
 */

package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.VIVOFinalApplication;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.daoimpl.RestaurantInfoDaoImpl;
import edu.nju.vivofinal.model.Restaurant;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VIVOFinalApplication.class)
@Transactional
public class RestaurantInfoDaoImplTest extends TestCase {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(baseDao0).update(any());
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      Restaurant restaurant0 = new Restaurant("XR]ocQ- e->g!#5Pg", "from Restaurant", "%s: %s", "XR]ocQ- e->g!#5Pg");
      boolean boolean0 = restaurantInfoDaoImpl0.updateRestaurantInfo(restaurant0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(baseDao0).save(any());
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      Restaurant restaurant0 = new Restaurant("XR]ocQ- e->g!#5Pg", "from Restaurant", "%s: %s", "XR]ocQ- e->g!#5Pg");
      boolean boolean0 = restaurantInfoDaoImpl0.saveRestaurantInfo(restaurant0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn((Object) null).when(session0).get(nullable(Class.class) , any(java.io.Serializable.class));
      doReturn((Transaction) null).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      Restaurant restaurant0 = restaurantInfoDaoImpl0.findRestaurantInfoById((String) null);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Restaurant restaurant0 = new Restaurant();
      // Undeclared exception!
      try { 
        restaurantInfoDaoImpl0.updateRestaurantInfo(restaurant0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("edu.nju.vivofinal.daoimpl.RestaurantInfoDaoImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      LinkedList<Object> linkedList0 = new LinkedList<Object>();
      Query<Object> query0 = (Query<Object>) mock(Query.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(query0).list();
      Transaction transaction0 = mock(Transaction.class, new ViolatedAssumptionAnswer());
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn(query0).when(session0).createQuery(anyString());
      doReturn(query0).when(session0).get(nullable(Class.class) , any(java.io.Serializable.class));
      doReturn(transaction0, transaction0).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0, session0, (Session) null).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      restaurantInfoDaoImpl0.showAllRestaurants();
      restaurantInfoDaoImpl0.findRestaurantInfoById("x<sN$JDht.iuEOHtp");
      Restaurant restaurant0 = restaurantInfoDaoImpl0.findRestaurantInfoById("x<sN$JDht.iuEOHtp");
      assertNull(restaurant0.getRestaurantType());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Query<String> query0 = (Query<String>) mock(Query.class, new ViolatedAssumptionAnswer());
      Restaurant restaurant0 = new Restaurant("", "", "", "");
      Transaction transaction0 = mock(Transaction.class, new ViolatedAssumptionAnswer());
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn(query0, restaurant0).when(session0).get(nullable(Class.class) , any(java.io.Serializable.class));
      doReturn(transaction0, transaction0).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0, session0).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      restaurantInfoDaoImpl0.findRestaurantInfoById("");
      Restaurant restaurant1 = restaurantInfoDaoImpl0.findRestaurantInfoById("");
      assertEquals("", restaurant1.getRestaurantName());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      LinkedList<Object> linkedList0 = new LinkedList<Object>();
      Query<Object> query0 = (Query<Object>) mock(Query.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(query0).list();
      Transaction transaction0 = mock(Transaction.class, new ViolatedAssumptionAnswer());
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn(query0).when(session0).createQuery(anyString());
      doReturn(query0).when(session0).get(nullable(Class.class) , any(java.io.Serializable.class));
      doReturn(transaction0, transaction0).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0, session0, (Session) null).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      restaurantInfoDaoImpl0.showAllRestaurants();
      Restaurant restaurant0 = restaurantInfoDaoImpl0.findRestaurantInfoById("x<sN$JDht.iuEOHtp");
      List<Restaurant> list0 = restaurantInfoDaoImpl0.showAllRestaurants();
      assertFalse(list0.contains(restaurant0));
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      LinkedList<String> linkedList0 = new LinkedList<String>();
      Query<String> query0 = (Query<String>) mock(Query.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(query0).list();
      Transaction transaction0 = mock(Transaction.class, new ViolatedAssumptionAnswer());
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn((Query<Restaurant>) null, query0).when(session0).createQuery(anyString());
      doReturn(transaction0, transaction0).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0, session0).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      List<Restaurant> list0 = restaurantInfoDaoImpl0.showAllRestaurants();
      List<Restaurant> list1 = restaurantInfoDaoImpl0.showAllRestaurants();
      assertNotSame(list1, list0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Stack<Object> stack0 = new Stack<Object>();
      Query<Object> query0 = (Query<Object>) mock(Query.class, new ViolatedAssumptionAnswer());
      doReturn(stack0, (List) null).when(query0).list();
      Transaction transaction0 = mock(Transaction.class, new ViolatedAssumptionAnswer());
      Integer integer0 = new Integer((-1));
      stack0.add((Object) integer0);
      Session session0 = mock(Session.class, new ViolatedAssumptionAnswer());
      doReturn(query0).when(session0).createQuery(anyString());
      doReturn(transaction0).when(session0).beginTransaction();
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(session0).when(baseDao0).getSession();
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      List<Restaurant> list0 = restaurantInfoDaoImpl0.showAllRestaurants();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Restaurant restaurant0 = new Restaurant("", "", "", "");
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(baseDao0).update(any());
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      boolean boolean0 = restaurantInfoDaoImpl0.updateRestaurantInfo(restaurant0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RestaurantInfoDaoImpl restaurantInfoDaoImpl0 = new RestaurantInfoDaoImpl();
      Restaurant restaurant0 = new Restaurant("", "", "", "");
      BaseDao baseDao0 = mock(BaseDao.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(baseDao0).save(any());
      Injector.inject(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class, "baseDao", (Object) baseDao0);
      Injector.validateBean(restaurantInfoDaoImpl0, (Class<?>) RestaurantInfoDaoImpl.class);
      boolean boolean0 = restaurantInfoDaoImpl0.saveRestaurantInfo(restaurant0);
      assertFalse(boolean0);
  }
}