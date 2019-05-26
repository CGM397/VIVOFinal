package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Repository
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    private long teacherId;

    private String teacherName;

    private String teacherMail;

    private String teacherPassword;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Parent> parents;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<ExamScore> examScores;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherMail, String teacherPassword,
                   List<Parent> parents, List<ExamScore> examScores) {
        this.teacherName = teacherName;
        this.teacherMail = teacherMail;
        this.teacherPassword = teacherPassword;
        this.parents = parents;
        this.examScores = examScores;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<ExamScore> getExamScores() {
        return examScores;
    }

    public void setExamScores(List<ExamScore> examScores) {
        this.examScores = examScores;
    }
}
