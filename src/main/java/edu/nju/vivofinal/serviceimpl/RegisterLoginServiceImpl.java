package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.CommonService;
import edu.nju.vivofinal.service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterLoginServiceImpl implements RegisterLoginService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ParentInfoDao parentInfoDao;
    @Autowired
    private TeacherInfoDao teacherInfoDao;

    private static final String WRONG = "wrong_password";

    private static final String SUCCESS = "success";

    private static final String DUPLICATE_MAIL = "duplicate_mail";

    @Override
    public String login(String identity, String account, String password) {
        String res = "";
        if(identity.equals("家长")) {
            res = parentLoginCheck(account, password);
        }else if(identity.equals("教师")) {
            res = teacherLoginCheck(account, password);
        }
        return res;
    }

    private String parentLoginCheck(String account, String password){
        String res;
        Parent parent = parentInfoDao.findParentByMail(account);
        if(parent == null || parent.getParentPassword() == null)
            res = WRONG;
        else if(parent.getParentPassword().equals(password)) {
                res = SUCCESS;
        }
        else
            res = WRONG;
        return res;
    }

    private String teacherLoginCheck(String account, String password){
        String res;
        Teacher teacher = teacherInfoDao.findTeacherByMail(account);
        if(teacher == null || teacher.getTeacherPassword() == null)
            res = WRONG;
        else if(teacher.getTeacherPassword().equals(password)) {
            res = SUCCESS;
        }
        else
            res = WRONG;
        return res;
    }

    @Override
    public String sendMail(String userMail) {
        List<Parent> parents = parentInfoDao.findAllParents();
        List<Teacher> teachers = teacherInfoDao.findAllTeachers();
        for(Parent one : parents) {
            if(one.getParentMail().equals(userMail))
                return DUPLICATE_MAIL;
        }
        for(Teacher one : teachers) {
            if(one.getTeacherMail().equals(userMail))
                return DUPLICATE_MAIL;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        String randomCode = commonService.generateRandomCode(6);
        message.setFrom("980231201@qq.com");
        message.setTo(userMail);
        message.setSubject("VIVOFinal : 邮箱验证");
        message.setText("验证码 : " + randomCode);
        mailSender.send(message);
        return randomCode;
    }

    @Override
    public boolean parentRegister(String parentMail, String parentPassword) {
        Parent parent = new Parent();
        parent.setParentMail(parentMail);
        parent.setParentPassword(parentPassword);
        return parentInfoDao.saveParentInfo(parent);
    }

    @Override
    public boolean teacherRegister(String teacherMail, String teacherPassword) {
        Teacher teacher = new Teacher();
        teacher.setTeacherMail(teacherMail);
        teacher.setTeacherPassword(teacherPassword);
        return teacherInfoDao.saveTeacherInfo(teacher);
    }
}
