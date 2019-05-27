package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.SpecificNotice;
import edu.nju.vivofinal.service.ParentInfoService;
import edu.nju.vivofinal.service.StatisticsService;
import edu.nju.vivofinal.statistics.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentInfoService parentInfoService;
    @Autowired
    private StatisticsService statisticsService;

    private static final String EMAIL = "email";

    @PostMapping(value = "/update")
    @ResponseBody
    public boolean update(@RequestBody Parent parent) {
        return parentInfoService.updateParentInfo(parent);
    }

    @PostMapping(value = "/findByMail")
    @ResponseBody
    public Parent findParentInfoByMail(@RequestParam String parentMail) {
        return parentInfoService.findParentByMail(parentMail);
    }

    @PostMapping(value = "/applyToJoinClass")
    @ResponseBody
    public boolean applyToJoinClass(@RequestParam String teacherMail, HttpServletRequest request) {
        String email = (String)request.getSession(true).getAttribute(EMAIL);
        return parentInfoService.applyToJoinClass(email, teacherMail);
    }

    @PostMapping(value = "/agreeApplication")
    @ResponseBody
    public boolean agreeApplication(@RequestParam long applicationId) {
        return parentInfoService.agreeApplication(applicationId);
    }

    @PostMapping(value = "/disagreeApplication")
    @ResponseBody
    public boolean disagreeApplication(@RequestParam long applicationId) {
        return parentInfoService.disagreeApplication(applicationId);
    }

    @PostMapping(value = "/showStudentScores")
    @ResponseBody
    public StudentScore showStudentScores(HttpServletRequest request) {
        return statisticsService.showStudentScores((String)request.getSession(true).getAttribute(EMAIL));
    }

    @PostMapping(value = "/showCommonNotices")
    @ResponseBody
    public List<CommonNotice> showCommonNotices(@RequestParam String parentMail) {
        return parentInfoService.showCommonNotices(parentMail);
    }

    @PostMapping(value = "/showOneCommonNotice")
    @ResponseBody
    public CommonNotice showOneCommonNotice(@RequestParam long commonNoticeId) {
        return parentInfoService.showOneCommonNotice(commonNoticeId);
    }

    @PostMapping(value = "/showSpecificNotices")
    @ResponseBody
    public List<SpecificNotice> showSpecificNotices(@RequestParam String parentMail) {
        return parentInfoService.showSpecificNotices(parentMail);
    }

    @PostMapping(value = "/showOneSpecificNotice")
    @ResponseBody
    public SpecificNotice showOneSpecificNotice(@RequestParam long specificNoticeId) {
        return parentInfoService.showOneSpecificNotice(specificNoticeId);
    }

}
