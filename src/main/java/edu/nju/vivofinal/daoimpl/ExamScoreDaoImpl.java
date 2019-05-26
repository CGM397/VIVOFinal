package edu.nju.vivofinal.daoimpl;

import edu.nju.vivofinal.dao.BaseDao;
import edu.nju.vivofinal.dao.ExamScoreDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.ExamScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamScoreDaoImpl implements ExamScoreDao {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public boolean saveExamScore(ExamScore examScore) {
        return baseDao.save(examScore);
    }

    @Override
    public boolean updateExamScore(ExamScore examScore) {
        return baseDao.update(examScore);
    }

    @Override
    public boolean deleteExamScore(long examScoreId) {
        return baseDao.delete(ExamScore.class, examScoreId);
    }

    @Override
    public ExamScore findExamScoreById(long examScoreId) {
        return (ExamScore) baseDao.findById(ExamScore.class, examScoreId);
    }

    @Override
    public List<ExamScore> findAllExamScores(long teacherId) {
        return teacherInfoDao.findTeacherById(teacherId).getExamScores();
    }
}
