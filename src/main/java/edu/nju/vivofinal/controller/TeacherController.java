package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.RegisterLoginService;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherInfoService teacherInfoService;

    @PostMapping(value = "/update")
    @ResponseBody
    public void update(@RequestBody Teacher teacher){
        teacherInfoService.updateTeacherInfo(teacher);
    }

    @PostMapping(value = "/findByMail")
    @ResponseBody
    public Teacher findTeacherInfoByMail(@RequestParam String teacherMail) {
        return teacherInfoService.findTeacherInfoByMail(teacherMail);
    }
}
