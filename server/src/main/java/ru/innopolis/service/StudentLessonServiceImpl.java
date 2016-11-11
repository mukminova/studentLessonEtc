package ru.innopolis.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.StudentsLessonEntity;
import ru.innopolis.repository.StudentsLessonRepository;
import ru.innopolis.model.StudentsLesson;

@Service("studentLessonService")
public class StudentLessonServiceImpl implements StudentLessonService {
    @Autowired
    StudentsLessonRepository studentsLessonRepository;

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();

    @Override
    public void addStudentLesson(StudentsLesson studentsLesson) {

        mapperFactory.classMap(StudentsLesson.class, StudentsLessonEntity.class);
        studentsLessonRepository.save(mapperFacade.map(studentsLesson, StudentsLessonEntity.class));
    }
}
