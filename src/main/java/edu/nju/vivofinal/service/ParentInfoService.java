package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.Parent;

public interface ParentInfoService {

    boolean updateParentInfo(Parent parent);

    boolean bindToTeacher(String parentMail, String teacherMail);

    Parent findParentByMail(String parentMail);

}
