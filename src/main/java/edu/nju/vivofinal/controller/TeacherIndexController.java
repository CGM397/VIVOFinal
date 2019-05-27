package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.StatisticsService;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TeacherIndexController {
    @Autowired
    TeacherInfoService teacherInfoServiceImpl;
    @Autowired
    StatisticsService statisticsService;

    @RequestMapping("/teacherHome")
    public String teacherHome(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("/teacherLogin");
            return null;
        }
        return "teacher/teacher-home";
    }

    @RequestMapping("/teacherInfo")
    public String teacherInfo(HttpServletRequest request, Model model){
        String email=(String)request.getSession(true).getAttribute("email");
        Teacher t=teacherInfoServiceImpl.findTeacherInfoByMail(email);
        model.addAttribute("teacher",t);
        model.addAttribute("percent",t.getInfoCompleteDegree());
        return "teacher/teacher-info";
    }

    @RequestMapping("/teacherStudents")
    public String teacherStudents(HttpServletRequest request,Model model){
        String email=(String)request.getSession(true).getAttribute("email");
        Teacher t=teacherInfoServiceImpl.findTeacherInfoByMail(email);
        model.addAttribute("parents",t.getParents());
        return "teacher/teacher-students";
    }

    @RequestMapping("/teacherStatistics")
    public String teacherStatistics(){
        return "teacher/teacher-statistics";
    }

    @RequestMapping("/teacherCommonNotice")
    public String teacherCommonNotice(HttpServletRequest request, Model model){
        String email=(String)request.getSession(true).getAttribute("email");
        Teacher t=teacherInfoServiceImpl.findTeacherInfoByMail(email);
        model.addAttribute("parents",t.getParents());
        return "teacher/teacher-commonNotice";
    }

    @RequestMapping("/teacherScoreNotice")
    public String teacherScoreNotice(){
        return "teacher/teacher-scoreNotice";
    }

    @RequestMapping("/teacherApprove")
    public String teacherScoreNotice(HttpServletRequest request, Model model){
        String email = (String)request.getSession(true).getAttribute("email");
        model.addAttribute("applications", teacherInfoServiceImpl.showAllApplications(email));
        return "teacher/teacher-approve";
    }
}
