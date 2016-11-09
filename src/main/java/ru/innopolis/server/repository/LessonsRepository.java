package ru.innopolis.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.server.entity.LessonsEntity;

/**
 * Created by Li on 09.11.16.
 */
public interface LessonsRepository extends CrudRepository<LessonsEntity, Integer> {
}
