package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.CommonNotice;

import java.util.List;

public interface CommonNoticeDao {

    boolean saveCommonNotice(CommonNotice commonNotice);

    CommonNotice findCommonNoticeById(long commonNoticeId);

    List<CommonNotice> findAllCommonNotices(long teacherId);

}
