package edu.nju.vivofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/cstlogin")
    public String cstLogin(){
        return "login/cstLogin";
    }

    @RequestMapping("/rstlogin")
    public String retLogin(){
        return "login/rstLogin";
    }

    @RequestMapping("/customer-home")
    public String customerHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("/login");
            return null;
        }
        return "customer/cstHome";
    }
}
