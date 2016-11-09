package ru.innopolis.common.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.innopolis.server.entity.StudentsEntity;

import java.util.List;
import java.util.Map;

/**
 * интерфейс сервиса студентов
 */
@Service
public interface StudentService {


    /**
     * получить список студентов
     *
     * @return
     */
    Iterable<StudentsEntity> getList();

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
     * @param name
     * @return
     */
    List<StudentsEntity> filterStudent(String name);

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
    Map<Integer, Integer> getMapWithCounts();
}
