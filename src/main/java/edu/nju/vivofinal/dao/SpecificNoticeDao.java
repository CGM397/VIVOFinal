package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.SpecificNotice;

import java.util.List;

public interface SpecificNoticeDao {

    boolean saveSpecificNotice(SpecificNotice specificNotice);

    SpecificNotice findSpecificNoticeById(long specificNoticeId);

    List<SpecificNotice> findAllSpecificNotices(long teacherId);

}
