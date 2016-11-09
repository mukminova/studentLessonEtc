package ru.innopolis.server.hibernateDao;

import ru.innopolis.server.entity.StudentsEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Li on 31.10.16.
 */
public interface StudentsDao {
    /**
     * получить список студентов
     *
     * @return
     */
    List<StudentsEntity> getAllStudents();

    /**
     * добавить студента
     *
     * @param student
     */
    void addStudent(StudentsEntity student);

    /**
     * найти студента по ид
     *
     * @param studentId
     * @return
     */
    StudentsEntity getStudentById(Integer studentId);

    /**
     * обновить данные студента
     *
     * @param student
     */
    void updateStudent(StudentsEntity student);

    /**
     * удалить студента по ид
     *
     * @param studentId
     */
    void deleteStudentById(Integer studentId);

    /**
     * фильтр студентов по имени
     *
     * @param student
     * @return
     */
    List<StudentsEntity> filterStudent(StudentsEntity student);

    /**
     * сортировка студентов по заданному параметру
     *
     * @param sortField
     * @return
     */
    List<StudentsEntity> sortStudentsByField(String sortField);

    /**
     * получить количество посещаемых занятий
     *
     * @return
     */
    Map<Integer, Integer> countVisitsWithStudentId();
}