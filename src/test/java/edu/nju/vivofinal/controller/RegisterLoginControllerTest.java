package edu.nju.vivofinal.controller;


import edu.nju.vivofinal.VIVOFinalApplication;
import junit.framework.TestCase;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VIVOFinalApplication.class)
public class RegisterLoginControllerTest extends TestCase {
    @Test(timeout = 4000)
    public void test00()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn("", "success").when(registerLoginService0).login(anyString() , anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
        HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
        doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
        registerLoginController0.login("", "", "", httpServletRequest0);
        HttpSession httpSession1 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
        HttpServletRequest httpServletRequest1 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
        doReturn(httpSession1).when(httpServletRequest1).getSession(anyBoolean());
        String string0 = registerLoginController0.login("dB", "success", "Ud", httpServletRequest1);
        assertEquals("success", string0);
    }

    @Test(timeout = 4000)
    public void test01()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn(false).when(registerLoginService0).customerRegister(anyString() , anyString() , anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        boolean boolean0 = registerLoginController0.customerRegister("GET", "", "", "");
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn("kt{IdQ").when(registerLoginService0).sendMail(anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        String string0 = registerLoginController0.sendMail("kt{IdQ");
        assertEquals("kt{IdQ", string0);
    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn((String) null, "").when(registerLoginService0).sendMail(anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        registerLoginController0.sendMail("HEAD");
        String string0 = registerLoginController0.sendMail("");
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn("N!k0VrAEW4 ").when(registerLoginService0).restaurantRegister(anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        String string0 = registerLoginController0.restaurantRegister("success", "W)PV-W");
        assertEquals("N!k0VrAEW4 ", string0);
    }

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn("").when(registerLoginService0).restaurantRegister(anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        String string0 = registerLoginController0.restaurantRegister("u`_rTS8`{E3@", "u`_rTS8`{E3@");
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn(true).when(registerLoginService0).customerRegister(anyString() , anyString() , anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        boolean boolean0 = registerLoginController0.customerRegister("$VALUES", "qB42|VJ_^M'", "$VALUES", "success");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
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
    public void test08()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn("cQD9UCo").when(registerLoginService0).login(anyString() , anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
        doReturn((HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
        // Undeclared exception!
        try {
            registerLoginController0.login("x([e&q", "x([e&q", "cQD9UCo", httpServletRequest0);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("edu.nju.vivofinal.controller.RegisterLoginController", e);
        }
    }

    @Test(timeout = 4000)
    public void test09()  throws Throwable  {
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
    public void test10()  throws Throwable  {
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
    public void test11()  throws Throwable  {
        RegisterLoginController registerLoginController0 = new RegisterLoginController();
        RegisterLoginService registerLoginService0 = mock(RegisterLoginService.class, new ViolatedAssumptionAnswer());
        doReturn((String) null).when(registerLoginService0).restaurantRegister(anyString() , anyString());
        Injector.inject(registerLoginController0, (Class<?>) RegisterLoginController.class, "registerLoginService", (Object) registerLoginService0);
        Injector.validateBean(registerLoginController0, (Class<?>) RegisterLoginController.class);
        String string0 = registerLoginController0.restaurantRegister("success", "success");
        assertNull(string0);
    }
}
