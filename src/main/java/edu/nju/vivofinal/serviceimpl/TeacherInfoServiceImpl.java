package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.ApplicationDao;
import edu.nju.vivofinal.dao.CommonNoticeDao;
import edu.nju.vivofinal.dao.SpecificNoticeDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.ParentApplication;
import edu.nju.vivofinal.model.SpecificNotice;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private CommonNoticeDao commonNoticeDao;
    @Autowired
    private SpecificNoticeDao specificNoticeDao;

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
        return teacherInfoDao.findTeacherByParentMail(parentMail);
    }

    @Override
    public List<ParentApplication> showAllApplications(String teacherMail) {
        return applicationDao.findApplicationsByTeacherMail(teacherMail);
    }

    @Override
    public List<CommonNotice> showAllCommonNotices(long teacherId) {
        return commonNoticeDao.findAllCommonNotices(teacherId);
    }

    @Override
    public CommonNotice showOneCommonNotice(long commonNoticeId) {
        return commonNoticeDao.findCommonNoticeById(commonNoticeId);
    }

    @Override
    public List<SpecificNotice> showAllSpecificNotices(long teacherId) {
        return specificNoticeDao.findAllSpecificNotices(teacherId);
    }

    @Override
    public SpecificNotice showOneSpecificNotice(long specificNoticeId) {
        return specificNoticeDao.findSpecificNoticeById(specificNoticeId);
    }
}
