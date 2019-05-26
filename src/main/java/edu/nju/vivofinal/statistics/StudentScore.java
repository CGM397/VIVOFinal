package edu.nju.vivofinal.statistics;

import java.util.Date;
import java.util.List;

public class StudentScore {

    private List<Date> examDate;

    private List<Double> scores;

    public StudentScore() {
    }

    public StudentScore(List<Date> examDate, List<Double> scores) {
        this.examDate = examDate;
        this.scores = scores;
    }

    public List<Date> getExamDate() {
        return examDate;
    }

    public void setExamDate(List<Date> examDate) {
        this.examDate = examDate;
    }

    public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }
}
