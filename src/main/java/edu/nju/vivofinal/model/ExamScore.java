package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Repository
public class ExamScore implements Serializable {

    @Id
    @GeneratedValue
    private long examScoreId;

    private String examName;

    private Date examTime;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<ScoreItem> items;

    public ExamScore() {
    }

    public ExamScore(String examName, Date examTime, List<ScoreItem> items) {
        this.examName = examName;
        this.examTime = examTime;
        this.items = items;
    }

    public long getExamScoreId() {
        return examScoreId;
    }

    public void setExamScoreId(long examScoreId) {
        this.examScoreId = examScoreId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public List<ScoreItem> getItems() {
        return items;
    }

    public void setItems(List<ScoreItem> items) {
        this.items = items;
    }
}
