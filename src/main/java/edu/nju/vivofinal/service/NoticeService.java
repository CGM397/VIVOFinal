package edu.nju.vivofinal.service;

import java.util.List;

public interface NoticeService {

    boolean sendCommonNotice(long teacherId, String title, String context);

    boolean sendOneSpecificNotice(long teacherId, long parentId, String title, String context);

    boolean sendSomeSpecificNotices(long teacherId, List<Long> parentIds, String title, String context);

    boolean sendExamScore();
}
