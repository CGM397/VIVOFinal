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
public class ParentApplication implements Serializable {

    @Id
    @GeneratedValue
    private long applicationId;

    private String teacherMail;

    private long parentId;

    private String parentName;

    private String studentId;

    private String studentName;

    private boolean checked;

    public ParentApplication() {
    }

    public ParentApplication(String teacherMail, long parentId, String parentName,
                             String studentId, String studentName, boolean checked) {
        this.teacherMail = teacherMail;
        this.parentId = parentId;
        this.parentName = parentName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.checked = checked;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
