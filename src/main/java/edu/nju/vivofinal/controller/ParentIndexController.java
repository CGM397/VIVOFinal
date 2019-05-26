package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.ParentInfoService;
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
public class ParentIndexController {
    @Autowired
    ParentInfoService parentInfoServiceImpl;

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
        return "parent/parent-info";
    }

    @RequestMapping("/parentScore")
    public String parentScore(){
        return "parent/parent-score";
    }
}
