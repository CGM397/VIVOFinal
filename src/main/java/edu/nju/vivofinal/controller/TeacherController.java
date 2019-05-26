package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.ExamScore;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.NoticeService;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private NoticeService noticeService;

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

    @PostMapping(value = "/findByParentMail")
    @ResponseBody
    public Teacher findTeacherByParentMail(@RequestParam String parentMail) {
        return teacherInfoService.findTeacherByParentMail(parentMail);
    }

    @PostMapping(value = "/sendCommonNotice")
    @ResponseBody
    public boolean sendCommonNotice(@RequestParam long teacherId, @RequestParam String title,
                                    @RequestParam String context) {
        return noticeService.sendCommonNotice(teacherId, title, context);
    }

    @PostMapping(value = "/sendOneSpecificNotice")
    @ResponseBody
    public boolean sendOneSpecificNotice(@RequestParam long teacherId, @RequestParam long parentId,
                                         @RequestParam String title, @RequestParam String context) {
        return noticeService.sendOneSpecificNotice(teacherId, parentId, title, context);
    }

    @PostMapping(value = "/sendSomeSpecificNotices")
    @ResponseBody
    public boolean sendSomeSpecificNotices(@RequestParam long teacherId,
                                           @RequestParam List<Long> parentIds,
                                           @RequestParam String title, @RequestParam String context) {
        return noticeService.sendSomeSpecificNotices(teacherId, parentIds, title, context);
    }

    @PostMapping(value = "/sendExamScore")
    @ResponseBody
    public boolean sendExamScore(@RequestBody ExamScore examScore, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long teacherId =
                teacherInfoService.findTeacherInfoByMail((String)session.getAttribute("email")).getTeacherId();
        return noticeService.sendExamScore(teacherId, examScore);
    }
}
