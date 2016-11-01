package ru.innopolis.server.dao;

import org.springframework.stereotype.Component;
import ru.innopolis.server.model.Lessons;

import java.util.List;


@Component
public interface LessonDao {
    /**
     * получить список занятий
     *
     * @return
     * @throws ClassNotFoundException
     */
    List<Lessons> getLessonList() throws ClassNotFoundException;
}
