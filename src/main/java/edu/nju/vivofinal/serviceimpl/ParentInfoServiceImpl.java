package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.ParentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ParentInfoServiceImpl implements ParentInfoService {

    @Autowired
    private ParentInfoDao parentInfoDao;
    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public boolean updateParentInfo(Parent parent) {
        List<Parent> parentList = parentInfoDao.findAllParents();
        for(Parent one : parentList){
            if(one.getStudentId().equals(parent.getStudentId()))
                return false;
        }
        return parentInfoDao.updateParentInfo(parent);
    }

    @Override
    public boolean bindToTeacher(String parentMail, String teacherMail) {
        boolean res;
        Parent parent = parentInfoDao.findParentByMail(parentMail);
        Teacher teacher = teacherInfoDao.findTeacherByMail(teacherMail);

        if(teacher == null || teacher.getTeacherPassword() == null){
            return false;
        }

        if(teacher.getParents() == null) {
            Set<Parent> store = new HashSet<>();
            store.add(parent);
            teacher.setParents(store);
            teacherInfoDao.updateTeacherInfo(teacher);
            return true;
        }

        List<Parent> parentList = new ArrayList<>(teacher.getParents());
        if (parentList.contains(parent)){
            res = false;
        }else{
            parentList.add(parent);
            teacher.setParents(new HashSet<>(parentList));
            teacherInfoDao.updateTeacherInfo(teacher);
            res = true;
        }
        return res;
    }

    @Override
    public Parent findParentByMail(String parentMail) {
        return parentInfoDao.findParentByMail(parentMail);
    }
}
