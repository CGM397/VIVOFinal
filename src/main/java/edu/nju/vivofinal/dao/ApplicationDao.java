package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Application;

import java.util.List;

public interface ApplicationDao {

    boolean saveApplication(Application application);

    boolean updateApplication(Application application);

    Application findApplicationById(long applicationId);

    List<Application> findApplicationsByTeacherMail(String teacherMail);
}
