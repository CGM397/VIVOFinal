package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.Parent;

public interface ParentInfoService {

    boolean updateParentInfo(Parent parent);

    Parent findParentByMail(String parentMail);

    boolean applyToJoinClass(String parentMail, String teacherMail);

    boolean agreeApplication(long applicationId);

    boolean disagreeApplication(long applicationId);
}
