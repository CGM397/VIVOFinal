package edu.nju.vivofinal.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Repository
public class SpecificNotice implements Serializable {

    @Id
    @GeneratedValue
    private long specificNoticeId;

    private Date specificNoticeTime;

    private long teacherId;

    private long parentId;

    private String title;

    private String context;

    public SpecificNotice() {
    }

    public SpecificNotice(Date specificNoticeTime, long teacherId, long parentId,
                          String title, String context) {
        this.specificNoticeTime = specificNoticeTime;
        this.teacherId = teacherId;
        this.parentId = parentId;
        this.title = title;
        this.context = context;
    }

    public long getSpecificNoticeId() {
        return specificNoticeId;
    }

    public void setSpecificNoticeId(long specificNoticeId) {
        this.specificNoticeId = specificNoticeId;
    }

    public Date getSpecificNoticeTime() {
        return specificNoticeTime;
    }

    public void setSpecificNoticeTime(Date specificNoticeTime) {
        this.specificNoticeTime = specificNoticeTime;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
