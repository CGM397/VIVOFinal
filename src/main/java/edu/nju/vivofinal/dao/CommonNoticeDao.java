package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.CommonNotice;

import java.util.List;

public interface CommonNoticeDao {

    boolean saveCommonNotice(CommonNotice commonNotice);

    boolean deleteCommonNotice(long commonNoticeId);

    CommonNotice findCommonNoticeById(long commonNoticeId);

    List<CommonNotice> findAllCommonNotices(long teacherId);

    List<CommonNotice> findCommonNoticesByParentMail(String parentMail);
}
