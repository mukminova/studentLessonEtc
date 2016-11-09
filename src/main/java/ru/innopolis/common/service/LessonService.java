package ru.innopolis.common.service;

import org.springframework.stereotype.Service;
import ru.innopolis.server.entity.LessonsEntity;
import ru.innopolis.server.entity.StudentsEntity;

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
    List<LessonsEntity> getLessonList();

    LessonsEntity getLessonById(int lessonId);
}
