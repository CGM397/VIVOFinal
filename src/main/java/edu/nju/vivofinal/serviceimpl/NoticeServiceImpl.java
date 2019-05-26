package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.CommonNoticeDao;
import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.SpecificNoticeDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.*;
import edu.nju.vivofinal.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TeacherInfoDao teacherInfoDao;
    @Autowired
    private ParentInfoDao parentInfoDao;
    @Autowired
    private CommonNoticeDao commonNoticeDao;
    @Autowired
    private SpecificNoticeDao specificNoticeDao;

    private static final String FROM_MAIL = "980231201@qq.com";

    @Override
    public boolean sendCommonNotice(long teacherId, String title, String context) {
        ArrayList<Parent> parents =
                new ArrayList<>(teacherInfoDao.findTeacherById(teacherId).getParents());
        String[] storeMails = new String[parents.size()];

        for(int i = 0; i < parents.size(); i++){
            storeMails[i] = parents.get(i).getParentMail();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_MAIL);
        message.setTo(storeMails);
        message.setSubject(title);
        message.setText(context);
        mailSender.send(message);

        CommonNotice commonNotice = new CommonNotice(new Date(), teacherId, title, context);
        return commonNoticeDao.saveCommonNotice(commonNotice);
    }

    @Override
    public boolean sendOneSpecificNotice(long teacherId, long parentId,
                                         String title, String context) {

        Parent parent = parentInfoDao.findParentById(parentId);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_MAIL);
        message.setTo(parent.getParentMail());
        message.setSubject(title);
        message.setText(context);
        mailSender.send(message);

        SpecificNotice specificNotice =
                new SpecificNotice(new Date(), teacherId, parentId, title, context);
        return specificNoticeDao.saveSpecificNotice(specificNotice);
    }

    @Override
    public boolean sendSomeSpecificNotices(long teacherId, List<Long> parentIds,
                                           String title, String context) {
        if (parentIds == null){
            return false;
        }

        boolean res = true;
        String[] storeMails = new String[parentIds.size()];

        for(int i = 0; i < parentIds.size(); i++){
            storeMails[i] = parentInfoDao.findParentById(parentIds.get(i)).getParentMail();
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_MAIL);
        message.setTo(storeMails);
        message.setSubject(title);
        message.setText(context);
        mailSender.send(message);

        for(long oneId : parentIds){
            SpecificNotice specificNotice =
                    new SpecificNotice(new Date(), teacherId, oneId, title, context);
            res &= specificNoticeDao.saveSpecificNotice(specificNotice);
        }
        return res;
    }

    @Override
    public boolean sendExamScore(long teacherId, ExamScore examScore) {
        boolean res = true;
        Teacher teacher = teacherInfoDao.findTeacherById(teacherId);
        Set<ExamScore> examScoreList = teacher.getExamScores();
        if(examScoreList == null) {
            examScoreList = new HashSet<>();
        }
        examScoreList.add(examScore);
        teacher.setExamScores(examScoreList);
        teacherInfoDao.updateTeacherInfo(teacher);

        Date sendTime = examScore.getExamTime();
        List<ScoreItem> items = examScore.getItems();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_MAIL);
        for(ScoreItem one : items) {
            Parent parent = parentInfoDao.findParentByStudentId(one.getStudentId());
            if(parent != null && parent.getParentMail() != null) {
                String title = "考试："+examScore.getExamName() + " 学生成绩";
                String context = "得分：" + one.getExamScore();
                message.setTo(parent.getParentMail());
                message.setSubject(title);
                message.setText(context);
                mailSender.send(message);
                SpecificNotice specificNotice = new SpecificNotice(sendTime,
                        teacher.getTeacherId(), parent.getParentId(), title, context);
                res &= specificNoticeDao.saveSpecificNotice(specificNotice);
            }
        }
        return res;
    }
}
