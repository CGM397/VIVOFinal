package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public void saveTeacherInfo(Teacher teacher) {
        teacherInfoDao.saveTeacherInfo(teacher);
    }

    @Override
    public Teacher findTeacherInfoByMail(String teacherMail) {
        return teacherInfoDao.findTeacherByMail(teacherMail);
    }
}
