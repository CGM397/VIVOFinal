package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Repository
public class ScoreItem implements Serializable {

    @Id
    @GeneratedValue
    private long scoreItemId;

    private String studentId;

    private double examScore;

    public ScoreItem() {
    }

    public ScoreItem(String studentId, double examScore) {
        this.studentId = studentId;
        this.examScore = examScore;
    }

    public long getScoreItemId() {
        return scoreItemId;
    }

    public void setScoreItemId(long scoreItemId) {
        this.scoreItemId = scoreItemId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }
}
