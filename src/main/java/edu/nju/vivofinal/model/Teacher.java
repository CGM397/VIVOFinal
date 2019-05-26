package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    private String teacherPhoneNumber;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Parent> parents;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<ExamScore> examScores;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherMail, String teacherPassword,
                   String teacherPhoneNumber, Set<Parent> parents, Set<ExamScore> examScores) {
        this.teacherName = teacherName;
        this.teacherMail = teacherMail;
        this.teacherPassword = teacherPassword;
        this.teacherPhoneNumber = teacherPhoneNumber;
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

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    public Set<ExamScore> getExamScores() {
        return examScores;
    }

    public void setExamScores(Set<ExamScore> examScores) {
        this.examScores = examScores;
    }
}
