package edu.nju.vivofinal.service;

import edu.nju.vivofinal.model.CommonNotice;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.SpecificNotice;

import java.util.List;

public interface ParentInfoService {

    boolean updateParentInfo(Parent parent);

    Parent findParentByMail(String parentMail);

    boolean applyToJoinClass(String parentMail, String teacherMail);

    boolean agreeApplication(long applicationId);

    boolean disagreeApplication(long applicationId);

    List<CommonNotice> showCommonNotices(String parentMail);

    CommonNotice showOneCommonNotice(long commonNoticeId);

    List<SpecificNotice> showSpecificNotices(String parentMail);

    SpecificNotice showOneSpecificNotice(long specificNoticeId);
}
