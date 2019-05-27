package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.service.ParentInfoService;
import edu.nju.vivofinal.service.StatisticsService;
import edu.nju.vivofinal.statistics.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentInfoService parentInfoService;
    @Autowired
    private StatisticsService statisticsService;

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
        String email = (String)request.getSession(true).getAttribute("email");
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
    public StudentScore showStudentScores(@RequestParam String parentMail) {
        return statisticsService.showStudentScores(parentMail);
    }

}
