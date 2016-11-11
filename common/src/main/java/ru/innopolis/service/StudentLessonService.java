package ru.innopolis.service;

import ru.innopolis.model.StudentsLesson;

/**
 * интерфейс сервиса посещений студентов занятий
 */
public interface StudentLessonService {
    /**
     * добавить посещение студента на занятие
     *
     * @param studentsLessonEntity
     */
    void addStudentLesson(StudentsLesson studentsLessonEntity);
}
