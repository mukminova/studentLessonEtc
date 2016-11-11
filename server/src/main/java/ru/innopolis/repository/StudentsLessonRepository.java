package ru.innopolis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.entity.StudentsLessonEntity;
import ru.innopolis.model.StudentsLesson;


public interface StudentsLessonRepository extends CrudRepository<StudentsLessonEntity, Integer> {

}
