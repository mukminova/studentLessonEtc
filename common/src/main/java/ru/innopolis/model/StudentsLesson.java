package ru.innopolis.model;

import java.io.Serializable;

/**
 * модель посещений
 */
public class StudentsLesson implements Serializable {
    private static final long serialVersionUID = -1112078003123343928L;
    private Integer studentLessonsId;
    private Integer studentId;
    private Integer lessonId;
    private Integer version;

    public Integer getStudentLessonsId() {
        return studentLessonsId;
    }

    public void setStudentLessonsId(Integer studentLessonsId) {
        this.studentLessonsId = studentLessonsId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
