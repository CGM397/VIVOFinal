package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.SpecificNotice;
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
import java.util.List;

@Controller
public class ParentIndexController {
    @Autowired
    public ParentInfoService parentInfoServiceImpl;
    @Autowired
    private TeacherInfoService teacherInfoService;

    private static final String EMAIL = "email";

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
        String email=(String)request.getSession(true).getAttribute(EMAIL);
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
    public String parentScore(){
        return "parent/parent-score";
    }

    @RequestMapping("/parentNotice")
    public String parentNotice(HttpServletRequest request, Model model) {
        String email = (String)request.getSession(true).getAttribute(EMAIL);
        List<CommonNotice> notices=parentInfoServiceImpl.showCommonNotices(email);
        List<SpecificNotice> sNotices=parentInfoServiceImpl.showSpecificNotices(email);
        for(SpecificNotice n:sNotices){
            CommonNotice common=new CommonNotice();
            common.setCommonNoticeId(n.getSpecificNoticeId());
            common.setCommonNoticeTime(n.getSpecificNoticeTime());
            common.setContext(n.getContext());
            common.setTitle(n.getTitle());
            common.setTeacherId(n.getTeacherId());
            notices.add(common);
        }
        model.addAttribute("notices",notices);
        return "parent/parent-notice";
    }
}
