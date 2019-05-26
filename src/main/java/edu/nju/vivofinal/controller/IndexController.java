package edu.nju.vivofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/parentLogin")
    public String parentLogin(){
        return "login/parentLogin";
    }

    @RequestMapping("/teacherLogin")
    public String teacherLogin(){
        return "login/teacherLogin";
    }

    @RequestMapping("/parentHome")
    public String parentHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("/parentlogin");
            return null;
        }
        return "parent/parent-home";
    }

    @RequestMapping("/parentInfo")
    public String parentInfo(){
        return "parent/parent-info";
    }

    @RequestMapping("/parentScore")
    public String parentScore(){
        return "parent/parent-score";
    }

    @RequestMapping("/teacherHome")
    public String teacherHome(){
        return "teacher/teacher-home";
    }

    @RequestMapping("/teacherInfo")
    public String teacherInfo(){
        return "teacher/teacher-info";
    }

    @RequestMapping("/teacherNotice")
    public String teacherNotice(){
        return "teacher/teacher-notice";
    }

    @RequestMapping("/teacherStudents")
    public String teacherStudents(){
        return "teacher/teacher-students";
    }

    @RequestMapping("/teacherStatistics")
    public String teacherStatistics(){
        return "teacher/teacher-statistics";
    }



}
