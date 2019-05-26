package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.ParentApplication;

import java.util.List;

public interface ApplicationDao {

    boolean saveApplication(ParentApplication parentApplication);

    boolean updateApplication(ParentApplication parentApplication);

    ParentApplication findApplicationById(long applicationId);

    List<ParentApplication> findApplicationsByTeacherMail(String teacherMail);
}
