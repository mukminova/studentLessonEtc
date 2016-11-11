package ru.innopolis.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.LessonsEntity;
import ru.innopolis.repository.LessonsRepository;
import ru.innopolis.model.Lessons;

import java.util.ArrayList;
import java.util.List;

@Service("lessonService")
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonsRepository lessonsRepository;
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();


    @Override
    public Iterable<Lessons> getLessonList() {
        mapperFactory.classMap(LessonsEntity.class, Lessons.class);
        List<LessonsEntity> lessonsEntities = (List<LessonsEntity>) lessonsRepository.findAll();
        List<Lessons> lessonsModel = new ArrayList<>();
        for (LessonsEntity lesson : lessonsEntities) {
            lessonsModel.add(mapperFacade.map(lesson, Lessons.class));
        }
        return lessonsModel;
    }

    @Override
    public Lessons getLessonByLessonId(int lessonId) {
        mapperFactory.classMap(LessonsEntity.class, Lessons.class);
        LessonsEntity lessonsEntity = lessonsRepository.findOne(lessonId);

        return mapperFacade.map(lessonsEntity, Lessons.class);
    }
}
