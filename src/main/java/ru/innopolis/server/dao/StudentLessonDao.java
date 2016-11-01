package ru.innopolis.server.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Li on 01.11.16.
 */
@Component
public interface StudentLessonDao {
    /**
     * добавить посещение студента на занятие
     *
     * @param studentId
     * @param lessonId
     * @throws ClassNotFoundException
     */
    void addStudentLesson(Integer studentId, Integer lessonId) throws ClassNotFoundException;
}
