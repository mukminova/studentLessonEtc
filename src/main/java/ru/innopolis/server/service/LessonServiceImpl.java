package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.LessonService;
import ru.innopolis.server.dao.LessonDao;
import ru.innopolis.server.model.Lessons;

import java.util.List;

@Component
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonDao lessonDao;

    @Override
    public List<Lessons> getLessonList() throws ClassNotFoundException {
        return lessonDao.getLessonList();
    }
}
