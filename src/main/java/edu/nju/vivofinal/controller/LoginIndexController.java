package edu.nju.vivofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginIndexController {

    @RequestMapping("")
    public String login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/parentLogin");
        return null;
    }

    @RequestMapping("/parentLogin")
    public String parentLogin(){
        return "login/parentLogin";
    }

    @RequestMapping("/teacherLogin")
    public String teacherLogin(){
        return "login/teacherLogin";
    }

}
