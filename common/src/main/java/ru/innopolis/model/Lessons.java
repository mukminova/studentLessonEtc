package ru.innopolis.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * модель занятий
 */
public class Lessons implements Serializable {
    private static final long serialVersionUID = 3186176645607472877L;
    private Integer lessonId;
    private String topic;
    private String description;
    private Integer duration;
    private Date date;
    private Integer version;

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
