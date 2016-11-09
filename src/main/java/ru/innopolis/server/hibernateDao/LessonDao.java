package ru.innopolis.server.hibernateDao;

import org.springframework.stereotype.Component;
import ru.innopolis.server.entity.LessonsEntity;

import java.util.List;


@Component
public interface LessonDao {
    /**
     * получить список занятий
     *
     * @return
     */
    List<LessonsEntity> getLessonList();

    LessonsEntity getLessonById(int lessonId);
}
