package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.ExamScore;
import edu.nju.vivofinal.model.SpecificNotice;
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
    public void update(@RequestBody Teacher teacher){ teacherInfoService.updateTeacherInfo(teacher);
    }

    @PostMapping(value = "/findByMail")
    @ResponseBody
    public Teacher findTeacherInfoByMail(@RequestParam String teacherMail) {
        return teacherInfoService.findTeacherInfoByMail(teacherMail);
    }

    @PostMapping(value = "/findNameByMail")
    @ResponseBody
    public String findNameByMail(@RequestParam String teacherMail) {
        Teacher one = teacherInfoService.findTeacherInfoByMail(teacherMail);
        if(one == null)
            return "无";
        else
            return one.getTeacherName();
    }

    @PostMapping(value = "/findByParentMail")
    @ResponseBody
    public Teacher findTeacherByParentMail(@RequestParam String parentMail) {
        return teacherInfoService.findTeacherByParentMail(parentMail);
    }

    @PostMapping(value = "/sendCommonNotice")
    @ResponseBody
    public boolean sendCommonNotice(@RequestParam String title,
                                    @RequestParam String context,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long teacherId =
                teacherInfoService.findTeacherInfoByMail((String)session.getAttribute("email")).getTeacherId();
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

    @PostMapping(value = "/showAllCommonNotices")
    @ResponseBody
    public List<CommonNotice> showAllCommonNotices(@RequestParam long teacherId) {
        return teacherInfoService.showAllCommonNotices(teacherId);
    }

    @PostMapping(value = "/showOneCommonNotice")
    @ResponseBody
    public CommonNotice showOneCommonNotice(@RequestParam long commonNoticeId) {
        return teacherInfoService.showOneCommonNotice(commonNoticeId);
    }

    @PostMapping(value = "/showAllSpecificNotices")
    @ResponseBody
    public List<SpecificNotice> showAllSpecificNotices(@RequestParam long teacherId) {
        return teacherInfoService.showAllSpecificNotices(teacherId);
    }

    @PostMapping(value = "/showOneSpecificNotice")
    @ResponseBody
    public SpecificNotice showOneSpecificNotice(@RequestParam long specificNoticeId) {
        return teacherInfoService.showOneSpecificNotice(specificNoticeId);
    }
}
