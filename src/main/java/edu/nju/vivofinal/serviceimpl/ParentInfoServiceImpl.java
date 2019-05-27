package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.*;
import edu.nju.vivofinal.model.*;
import edu.nju.vivofinal.service.NoticeService;
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
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private CommonNoticeDao commonNoticeDao;
    @Autowired
    private SpecificNoticeDao specificNoticeDao;

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
        boolean res;
        ParentApplication parentApplication = applicationDao.findApplicationById(applicationId);
        parentApplication.setChecked(true);
        applicationDao.updateApplication(parentApplication);
        Teacher teacher = teacherInfoDao.findTeacherByMail(parentApplication.getTeacherMail());
        long teacherId = teacher.getTeacherId();
        String teacherName = teacher.getTeacherName();
        String title = "加入班级申请结果";
        String context = teacherName + "老师接受了您加入班级的申请。";
        res = bindToTeacher(parentApplication.getParentId(), parentApplication.getTeacherMail()) &&
                noticeService.sendOneSpecificNotice(teacherId, parentApplication.getParentId(), title, context);
        return res;
    }

    @Override
    public boolean disagreeApplication(long applicationId) {
        boolean res;
        ParentApplication parentApplication = applicationDao.findApplicationById(applicationId);
        parentApplication.setChecked(true);
        long teacherId =
                teacherInfoDao.findTeacherByMail(parentApplication.getTeacherMail()).getTeacherId();
        String teacherName =
                teacherInfoDao.findTeacherByMail(parentApplication.getTeacherMail()).getTeacherName();
        String title = "加入班级申请结果";
        String context = teacherName + "老师拒绝了您加入班级的申请。";
        res = applicationDao.updateApplication(parentApplication) &&
                noticeService.sendOneSpecificNotice(teacherId, parentApplication.getParentId(), title, context);
        return res;
    }

    @Override
    public List<CommonNotice> showCommonNotices(String parentMail) {
        return commonNoticeDao.findCommonNoticesByParentMail(parentMail);
    }

    @Override
    public CommonNotice showOneCommonNotice(long commonNoticeId) {
        return commonNoticeDao.findCommonNoticeById(commonNoticeId);
    }

    @Override
    public List<SpecificNotice> showSpecificNotices(String parentMail) {
        return specificNoticeDao.findSpecificNoticesByParentMail(parentMail);
    }

    @Override
    public SpecificNotice showOneSpecificNotice(long specificNoticeId) {
        return specificNoticeDao.findSpecificNoticeById(specificNoticeId);
    }
}
