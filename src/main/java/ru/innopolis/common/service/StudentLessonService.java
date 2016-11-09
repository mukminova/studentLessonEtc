package ru.innopolis.common.service;

import org.springframework.stereotype.Service;
import ru.innopolis.server.entity.StudentsLessonEntity;

/**
 * интерфейс сервиса посещений студентов занятий
 */
@Service
public interface StudentLessonService {
    /**
     * добавить посещение студента на занятие
     *
     * @param studentsLessonEntity
     */
    void addStudentLesson(StudentsLessonEntity studentsLessonEntity);
}
