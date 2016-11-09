package ru.innopolis.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.server.entity.StudentsLessonEntity;


public interface StudentsLessonRepository extends CrudRepository<StudentsLessonEntity, Integer> {
}
