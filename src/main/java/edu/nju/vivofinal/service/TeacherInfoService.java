package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.ParentApplication;
import edu.nju.vivofinal.model.SpecificNotice;
import edu.nju.vivofinal.model.Teacher;

import java.util.List;

public interface TeacherInfoService {

    void updateTeacherInfo(Teacher teacher);

    Teacher findTeacherInfoByMail(String teacherMail);

    Teacher findTeacherByParentMail(String parentMail);

    List<ParentApplication> showAllApplications(String teacherMail);

    List<CommonNotice> showAllCommonNotices(long teacherId);

    CommonNotice showOneCommonNotice(long commonNoticeId);

    List<SpecificNotice> showAllSpecificNotices(long teacherId);

    SpecificNotice showOneSpecificNotice(long specificNoticeId);
}
