package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.StudentLessonService;
import ru.innopolis.server.entity.StudentsLessonEntity;
import ru.innopolis.server.hibernateDao.StudentLessonDao;

@Component
public class StudentLessonServiceImpl implements StudentLessonService {
    @Autowired
    StudentLessonDao studentLessonDao;
    @Override
    public void addStudentLesson(StudentsLessonEntity studentsLessonEntity) {
        studentLessonDao.addStudentLesson(studentsLessonEntity);
    }
}
