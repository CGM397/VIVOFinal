package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.ApplicationDao;
import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.ParentApplication;
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
    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public boolean updateParentInfo(Parent parent) {
        List<Parent> parentList = parentInfoDao.findAllParents();
        for(Parent one : parentList) {
            if(one.getStudentId() != null && one.getStudentId().equals(parent.getStudentId()))
                return false;
        }
        return parentInfoDao.updateParentInfo(parent);
    }

    private boolean bindToTeacher(long parentId, String teacherMail) {
        boolean res;
        Parent parent = parentInfoDao.findParentById(parentId);
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

    @Override
    public boolean applyToJoinClass(String parentMail, String teacherMail) {
        Parent parent = parentInfoDao.findParentByMail(parentMail);
        Teacher teacher = teacherInfoDao.findTeacherByMail(teacherMail);
        if(teacher == null ||parent == null ||
                teacher.getTeacherPassword() == null || parent.getParentPassword() == null)
            return false;
        if(parent.getInfoCompleteDegree() < 100.0)
            return false;
        ParentApplication parentApplication = new ParentApplication(teacherMail, parent.getParentId(),
                parent.getParentName(), parent.getStudentId(), parent.getStudentName(),
                false);
        return applicationDao.saveApplication(parentApplication);
    }

    @Override
    public boolean agreeApplication(long applicationId) {
        ParentApplication parentApplication = applicationDao.findApplicationById(applicationId);
        parentApplication.setChecked(true);
        applicationDao.updateApplication(parentApplication);
        return bindToTeacher(parentApplication.getParentId(), parentApplication.getTeacherMail());
    }

    @Override
    public boolean disagreeApplication(long applicationId) {
        ParentApplication parentApplication = applicationDao.findApplicationById(applicationId);
        parentApplication.setChecked(true);
        return applicationDao.updateApplication(parentApplication);
    }
}
