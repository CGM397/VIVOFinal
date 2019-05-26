package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Repository
public class Parent implements Serializable {

    @Id
    @GeneratedValue
    private long parentId;

    private String parentName;

    private String parentMail;

    private String parentPassword;

    private String parentPhoneNumber;

    private String studentId;

    private String studentName;

    public Parent() {
    }

    public Parent(String parentName, String parentMail, String parentPassword,
                  String parentPhoneNumber, String studentId, String studentName) {
        this.parentName = parentName;
        this.parentMail = parentMail;
        this.parentPassword = parentPassword;
        this.parentPhoneNumber = parentPhoneNumber;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentMail() {
        return parentMail;
    }

    public void setParentMail(String parentMail) {
        this.parentMail = parentMail;
    }

    public String getParentPassword() {
        return parentPassword;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getInfoCompleteDegree(){
        int flag = 0;
        if(this.getParentMail() == null)
            flag++;
        if(this.getParentPassword() == null)
            flag++;
        if(this.getParentName() == null)
            flag++;
        if(this.getParentPhoneNumber() == null)
            flag++;
        if(this.getStudentId() == null)
            flag++;
        if(this.getStudentName() == null)
            flag++;
        return Math.round(((6 - flag) * (100 / 6.0)) * 100) / 100.0;
    }
}
