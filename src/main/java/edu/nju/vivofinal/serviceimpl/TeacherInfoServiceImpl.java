package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public void updateTeacherInfo(Teacher teacher) {
        teacherInfoDao.updateTeacherInfo(teacher);
    }

    @Override
    public Teacher findTeacherInfoByMail(String teacherMail) {
        return teacherInfoDao.findTeacherByMail(teacherMail);
    }

    @Override
    public Teacher findTeacherByParentMail(String parentMail) {
        Teacher res = null;
        boolean flag = false;
        List<Teacher> teacherList = teacherInfoDao.findAllTeachers();
        for(Teacher one : teacherList){
            if(one.getParents() != null && !one.getParents().isEmpty()){
                List<Parent> parentList = new ArrayList<>(one.getParents());
                for(Parent oneParent : parentList){
                    if(oneParent.getParentMail().equals(parentMail)){
                        res = one;
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        return res;
    }
}
