package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.Parent;

public interface ParentInfoService {

    void saveParentInfo(Parent parent);

    boolean bindToTeacher(long parentId, long teacherId);

    Parent findParentByMail(String parentMail);

}
