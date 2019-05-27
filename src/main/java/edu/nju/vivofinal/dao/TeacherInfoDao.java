package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Teacher;

import java.util.List;

public interface TeacherInfoDao {

    boolean saveTeacherInfo(Teacher teacher);

    boolean updateTeacherInfo(Teacher teacher);

    boolean deleteTeacherInfo(long teacherId);

    Teacher findTeacherById(long teacherId);

    Teacher findTeacherByMail(String teacherMail);

    List<Teacher> findAllTeachers();

    Teacher findTeacherByParentMail(String parentMail);
}
