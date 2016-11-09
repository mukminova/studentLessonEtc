package ru.innopolis.server.hibernateDao;

import org.springframework.stereotype.Component;
import ru.innopolis.server.entity.StudentsLessonEntity;

/**
 * Created by Li on 01.11.16.
 */
@Component
public interface StudentLessonDao {
    /**
     * добавить посещение студента на занятие
     *
     * @param studentsLessonEntity
     */
    void addStudentLesson(StudentsLessonEntity studentsLessonEntity);
}
