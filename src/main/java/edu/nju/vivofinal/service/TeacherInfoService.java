package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.Teacher;

public interface TeacherInfoService {

    void updateTeacherInfo(Teacher teacher);

    Teacher findTeacherInfoByMail(String teacherMail);

    Teacher findTeacherByParentMail(String parentMail);

}
