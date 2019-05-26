package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.ParentApplication;
import edu.nju.vivofinal.model.Teacher;

import java.util.List;

public interface TeacherInfoService {

    void updateTeacherInfo(Teacher teacher);

    Teacher findTeacherInfoByMail(String teacherMail);

    Teacher findTeacherByParentMail(String parentMail);

    List<ParentApplication> showAllApplications(String teacherMail);

}
