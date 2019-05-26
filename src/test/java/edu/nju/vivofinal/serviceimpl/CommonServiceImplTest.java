package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.VIVOFinalApplication;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.dao.CustomerInfoDao;
import edu.nju.vivofinal.dao.RestaurantInfoDao;
import edu.nju.vivofinal.serviceimpl.CommonServiceImpl;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.Random;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VIVOFinalApplication.class)
public class CommonServiceImplTest {

    @Test(timeout = 4000)
    public void test0()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateRandomCode(7);
        commonServiceImpl0.generateRandomCode(0);
    }

    @Test(timeout = 4000)
    public void test1()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        doReturn((List) null).when(restaurantInfoDao0).showAllRestaurants();
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateId(2115, "edu.nju.vivofinal.mode.Customer");
        String string0 = "6(ldP3,?Jd\\-(";
        commonServiceImpl0.generateId(3588, "6(ldP3,?Jd-(");
        int int0 = (-1436);
        commonServiceImpl0.generateId((-1436), ";$'h");
        // Undeclared exception!
        try {
            commonServiceImpl0.generateId(3863, "restaurant");
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
        }
    }

    @Test(timeout = 4000)
    public void test2()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateId(1834, "\"IUXPe(\u0007BLUvacL57");
        int int0 = 0;
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId((-631), "F:Gr7RWDFZ<WH8du|}t");
        commonServiceImpl0.generateId((-631), "1");
        int int1 = 0;
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId(0, "1");
        commonServiceImpl0.generateId(2181, "");
        commonServiceImpl0.generateRandomCode((-109));
        // Undeclared exception!
        try {
            commonServiceImpl0.generateId((-631), (String) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
        }
    }

    @Test(timeout = 4000)
    public void test3()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateId(40, "r3rMO<Rk!7H':]b");
        commonServiceImpl0.generateRandomCode((-1));
        commonServiceImpl0.generateRandomCode(1);

    }

    @Test(timeout = 4000)
    public void test4()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        doReturn((List) null).when(restaurantInfoDao0).showAllRestaurants();
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        // Undeclared exception!
        try {
            commonServiceImpl0.generateId(5611, "restaurant");
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
        }
    }

    @Test(timeout = 4000)
    public void test5()  throws Throwable  {
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
    }

    @Test(timeout = 4000)
    public void test6()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        doReturn((List) null).when(customerInfoDao0).showAllCustomers();
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        // Undeclared exception!
        try {
            commonServiceImpl0.generateId((-916), "customer");
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
        }
    }

    @Test(timeout = 4000)
    public void test7()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        doReturn((List) null).when(restaurantInfoDao0).showAllRestaurants();
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateId(48, "edu.nju.vivofinal.model.Customer");
        int int0 = 2329;
        commonServiceImpl0.generateId(2329, "g`)!NAL&,-3v");
        int int1 = 0;
        // Undeclared exception!
        try {
            commonServiceImpl0.generateId(0, "restaurant");
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
        }
    }

    @Test(timeout = 4000)
    public void test8()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateId((-1), "restauranW");
        commonServiceImpl0.generateId(0, "?f[Aobfz");
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId(0, "");
        commonServiceImpl0.generateId(0, "1");
        commonServiceImpl0.generateRandomCode((-2887));
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId(0, "");
        commonServiceImpl0.generateRandomCode((-1));
        commonServiceImpl0.generateId(0, "");
        commonServiceImpl0.generateId(2181, "'9G5_-p605+t+6W/-");
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId((-1057), "!pu?8AA~");
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId((-1), "![>");
    }

    @Test(timeout = 4000)
    public void test9()  throws Throwable  {
        CommonServiceImpl commonServiceImpl0 = new CommonServiceImpl();
        CustomerInfoDao customerInfoDao0 = mock(CustomerInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "customerInfoDao", (Object) customerInfoDao0);
        RestaurantInfoDao restaurantInfoDao0 = mock(RestaurantInfoDao.class, new ViolatedAssumptionAnswer());
        Injector.inject(commonServiceImpl0, (Class<?>) CommonServiceImpl.class, "restaurantInfoDao", (Object) restaurantInfoDao0);
        Injector.validateBean(commonServiceImpl0, (Class<?>) CommonServiceImpl.class);
        commonServiceImpl0.generateRandomCode(1);
        String string0 = commonServiceImpl0.generateId(3249, "edu.nju.vivofinal.serviceimpl.CommonServiceImpl");
        int int0 = 2167;
        String string1 = commonServiceImpl0.generateId(2167, "ej`PRTGbdD");
        commonServiceImpl0.generateId(2167, string1);
        commonServiceImpl0.generateRandomCode(0);
        commonServiceImpl0.generateId(0, string0);
    }}