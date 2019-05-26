package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.Parent;

import java.util.List;

public interface ParentInfoDao {

    boolean saveParentInfo(Parent parent);

    boolean updateParentInfo(Parent parent);

    boolean deleteParentInfo(long parentId);

    Parent findParentById(long parentId);

    Parent findParentByMail(String parentMail);

    List<Parent> findAllParentsByTeacherId(long teacherId);

    List<Parent> findAllParents();

    Parent findParentByStudentId(String studentId);
}
