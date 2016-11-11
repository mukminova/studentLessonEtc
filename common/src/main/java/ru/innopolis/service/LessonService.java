package ru.innopolis.service;


import ru.innopolis.model.Lessons;

/**
 * интерфейс сервиса занятий
 */
//@Service
public interface LessonService {
    /**
     * получить список занятий
     *
     * @return
     */
    Iterable<Lessons> getLessonList();

    Lessons getLessonByLessonId(int lessonId);
}
