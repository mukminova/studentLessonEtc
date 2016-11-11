package ru.innopolis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.innopolis.entity.StudentsEntity;

import java.util.List;


public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

    @Query("select s from StudentsEntity s order by s.name")
    List<StudentsEntity> sortOrderBy(String columnName);

    @Query("select s from StudentsEntity s where s.name like ?1%")
    List<StudentsEntity> findByAndSort(String name);

//    @Query("SELECT s.studentId from LessonsEntity l " +
//            "LEFT JOIN StudentsLessonEntity v on l.lessonId = v.lessonsByLessonId.lessonId " +
//            "LEFT JOIN StudentsEntity s on v.studentsByStudentId.studentId = s.studentId " +
//            "GROUP BY s.studentId")
//    Map<Integer, Integer> countVisitsWithStudentId();
}
