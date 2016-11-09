package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.StudentLessonService;
import ru.innopolis.server.entity.StudentsLessonEntity;
import ru.innopolis.server.repository.StudentsLessonRepository;

@Component
public class StudentLessonServiceImpl implements StudentLessonService {
    @Autowired
    StudentsLessonRepository studentsLessonRepository;

    @Override
    public void addStudentLesson(StudentsLessonEntity studentsLessonEntity) {
        studentsLessonRepository.save(studentsLessonEntity);
    }
}
