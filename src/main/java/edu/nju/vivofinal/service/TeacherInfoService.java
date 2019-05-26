package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.Teacher;

public interface TeacherInfoService {

    void saveTeacherInfo(Teacher teacher);

    Teacher findTeacherInfoByMail(String teacherMail);

}
