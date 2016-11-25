package ru.innopolis.server.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

import java.io.Serializable;


@Entity
@Table(name = "students_lesson")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class StudentsLessonEntity implements Serializable {
    private Integer id;
    private StudentsEntity studentsByStudentId;
    private LessonsEntity lessonsByLessonId;

    public StudentsLessonEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "students_lesson_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    public LessonsEntity getLessonsByLessonId() {
        return lessonsByLessonId;
    }

    public void setLessonsByLessonId(LessonsEntity lessonsByLessonId) {
        this.lessonsByLessonId = lessonsByLessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsLessonEntity that = (StudentsLessonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
