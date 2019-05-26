package edu.nju.vivofinal.dao;

import edu.nju.vivofinal.model.ExamScore;

import java.util.List;

public interface ExamScoreDao {

    boolean saveExamScore(ExamScore examScore);

    boolean updateExamScore(ExamScore examScore);

    boolean deleteExamScore(long examScoreId);

    ExamScore findExamScoreById(long examScoreId);

    List<ExamScore> findAllExamScores(long teacherId);

}
