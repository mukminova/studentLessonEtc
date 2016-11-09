package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.LessonService;
import ru.innopolis.server.entity.LessonsEntity;
import ru.innopolis.server.hibernateDao.LessonDao;

import java.util.List;

@Component
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonDao lessonDao;

    @Override
    public List<LessonsEntity> getLessonList() {
        return lessonDao.getLessonList();
    }

    @Override
    public LessonsEntity getLessonById(int lessonId) {
        return lessonDao.getLessonById(lessonId);
    }
}
