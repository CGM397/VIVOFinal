package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.VIVOFinalApplication;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.nju.vivofinal.controller.IndexController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VIVOFinalApplication.class)
public class IndexControllerTest extends TestCase {

    @Test(timeout = 4000)
    public void test0()  throws Throwable  {
        IndexController indexController0 = new IndexController();
        HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
        // Undeclared exception!
        try {
            indexController0.customerHome((HttpServletRequest) null, httpServletResponse0);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("edu.nju.vivofinal.controller.IndexController", e);
        }
    }

    @Test(timeout = 4000)
    public void test1()  throws Throwable  {
        IndexController indexController0 = new IndexController();
        HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
        doReturn((HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
        HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
        String string0 = indexController0.customerHome(httpServletRequest0, httpServletResponse0);
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test2()  throws Throwable  {
        IndexController indexController0 = new IndexController();
        HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
        HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
        doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
        HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
        String string0 = indexController0.customerHome(httpServletRequest0, httpServletResponse0);
        assertEquals("customer/cstHome", string0);
        assertNotNull(string0);
    }

    @Test(timeout = 4000)
    public void test3()  throws Throwable  {
        IndexController indexController0 = new IndexController();
        String string0 = indexController0.cstLogin();
        assertEquals("login/cstLogin", string0);
    }

    @Test(timeout = 4000)
    public void test4()  throws Throwable  {
        IndexController indexController0 = new IndexController();
        String string0 = indexController0.retLogin();
        assertEquals("login/rstLogin", string0);
    }
}