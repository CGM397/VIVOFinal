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
public class CommonNotice implements Serializable {

    @Id
    @GeneratedValue
    private long commonNoticeId;

    private Date commonNoticeTime;

    private long teacherId;

    private String title;

    private String context;

    public CommonNotice() {
    }

    public CommonNotice(Date commonNoticeTime, long teacherId, String title, String context) {
        this.commonNoticeTime = commonNoticeTime;
        this.teacherId = teacherId;
        this.title = title;
        this.context = context;
    }

    public long getCommonNoticeId() {
        return commonNoticeId;
    }

    public void setCommonNoticeId(long commonNoticeId) {
        this.commonNoticeId = commonNoticeId;
    }

    public Date getCommonNoticeTime() {
        return commonNoticeTime;
    }

    public void setCommonNoticeTime(Date commonNoticeTime) {
        this.commonNoticeTime = commonNoticeTime;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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
