package edu.nju.vivofinal.service;

public interface NoticeService {

    boolean sendCommonNotice(long teacherId, String title, String context);

    boolean sendSpecificNotice(long teacherId, long parentId, String title, String context);

}
