package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.LessonService;
import ru.innopolis.server.entity.LessonsEntity;
import ru.innopolis.server.repository.LessonsRepository;

@Component
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonsRepository lessonsRepository;

    @Override
    public Iterable<LessonsEntity> getLessonList() {
        return lessonsRepository.findAll();
    }

    @Override
    public LessonsEntity getLessonByLessonId(int lessonId) {
        return lessonsRepository.findOne(lessonId);
    }
}
