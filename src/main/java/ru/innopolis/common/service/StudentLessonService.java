package ru.innopolis.common.service;

import org.springframework.stereotype.Component;

/**
 * интерфейс сервиса посещений студентов занятий
 */
@Component
public interface StudentLessonService {
    /**
     * добавить посещение студента на занятие
     *
     * @param studentId
     * @param lessonId
     * @throws ClassNotFoundException
     */
    void addStudentLesson(Integer studentId, Integer lessonId) throws ClassNotFoundException;
}
