package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.ParentInfoService;
import edu.nju.vivofinal.service.RegisterLoginService;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentInfoService parentInfoService;

    @PostMapping(value = "/update")
    @ResponseBody
    public void update(@RequestBody Parent parent){
        parentInfoService.updateParentInfo(parent);
    }

    @PostMapping(value = "/findByMail")
    @ResponseBody
    public Parent findParentInfoByMail(@RequestParam String parentMail) {
        return parentInfoService.findParentByMail(parentMail);
    }

    @PostMapping(value = "/bindToTeacher")
    @ResponseBody
    public boolean bindToTeacher(@RequestParam String parentMail, @RequestParam String teacherMail){
        return parentInfoService.bindToTeacher(parentMail, teacherMail);
    }
}
