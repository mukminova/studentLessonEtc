package ru.innopolis.server.model;

/**
 * модель посещений
 */
public class StudentLessons {
    private Integer studentLessonsId;
    private Integer studentId;
    private Integer lessonId;

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
}
