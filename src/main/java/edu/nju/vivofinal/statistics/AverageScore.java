package edu.nju.vivofinal.statistics;

import java.util.Date;
import java.util.List;

public class AverageScore {

    private List<Date> examDate;

    private List<Double> averageScores;

    public AverageScore() {
    }

    public AverageScore(List<Date> examDate, List<Double> averageScores) {
        this.examDate = examDate;
        this.averageScores = averageScores;
    }

    public List<Date> getExamDate() {
        return examDate;
    }

    public void setExamDate(List<Date> examDate) {
        this.examDate = examDate;
    }

    public List<Double> getAverageScores() {
        return averageScores;
    }

    public void setAverageScores(List<Double> averageScores) {
        this.averageScores = averageScores;
    }
}
