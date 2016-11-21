package ru.innopolis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.entity.StudentsEntity;



public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

}
