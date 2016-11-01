package ru.innopolis.common.service;

import org.springframework.stereotype.Component;
import ru.innopolis.server.model.Lessons;

import java.util.List;

/**
 * интерфейс сервиса занятий
 */
@Component
public interface LessonService {
    /**
     * получить список занятий
     * @return
     * @throws ClassNotFoundException
     */
    List<Lessons> getLessonList() throws ClassNotFoundException;
}
