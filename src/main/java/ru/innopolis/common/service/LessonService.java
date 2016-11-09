package ru.innopolis.common.service;

import org.springframework.stereotype.Service;
import ru.innopolis.server.entity.LessonsEntity;

import java.util.List;

/**
 * интерфейс сервиса занятий
 */
@Service
public interface LessonService {
    /**
     * получить список занятий
     * @return
     */
    Iterable<LessonsEntity> getLessonList();

    LessonsEntity getLessonByLessonId(int lessonId);
}
