package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.ParentInfoService;
import edu.nju.vivofinal.service.StatisticsService;
import edu.nju.vivofinal.service.TeacherInfoService;
import edu.nju.vivofinal.statistics.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ParentIndexController {
    @Autowired
    private ParentInfoService parentInfoServiceImpl;
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private TeacherInfoService teacherInfoService;

    @RequestMapping("/parentHome")
    public String parentHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("/");
            return null;
        }
        return "parent/parent-home";
    }

    @RequestMapping("/parentInfo")
    public String parentInfo(HttpServletRequest request, Model model){
        String email=(String)request.getSession(true).getAttribute("email");
        Parent p=parentInfoServiceImpl.findParentByMail(email);
        model.addAttribute("parent",p);
        model.addAttribute("percent",p.getInfoCompleteDegree());
        Teacher t = teacherInfoService.findTeacherByParentMail(email);
        if(t==null){
            model.addAttribute("teacherName","无");
        }else{
            model.addAttribute("teacherName",t.getTeacherName());
        }
        return "parent/parent-info";
    }

    @RequestMapping("/parentScore")
    public String parentScore(HttpServletRequest request, Model model){
        String email = (String)request.getSession(true).getAttribute("email");
        StudentScore studentScore = statisticsService.showStudentScores(email);
        model.addAttribute("examDate", studentScore.getExamDate());
        model.addAttribute("scores", studentScore.getScores());
        return "parent/parent-score";
    }
}
