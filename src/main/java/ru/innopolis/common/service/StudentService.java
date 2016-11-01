package ru.innopolis.common.service;

import org.springframework.stereotype.Component;
import ru.innopolis.server.model.Students;

import java.util.List;
import java.util.Map;

/**
 * интерфейс сервиса студентов
 */
@Component
public interface StudentService {
    /**
     * получить список студентов
     * @return
     * @throws ClassNotFoundException
     */
    List<Students> getList() throws ClassNotFoundException;

    /**
     * добавить студента
     * @param student
     */
    void addStudent(Students student);

    /**
     * найти студента по ид
     * @param studentId
     * @return
     * @throws ClassNotFoundException
     */
    Students getStudentById(Integer studentId) throws ClassNotFoundException;

    /**
     * обновить данные студента
     * @param student
     */
    void updateStudent(Students student);

    /**
     * удалить студента по ид
     * @param studentId
     */
    void deleteStudentById(Integer studentId);

    /**
     * фильтр студентов по имени
     * @param student
     * @return
     */
    List<Students> filterStudent(Students student);

    /**
     * сортировка студентов по заданному параметру
     * @param sortField
     * @return
     */
    List<Students> sortStudentsByField(String sortField);

    /**
     * получить количество посещаемых занятий
     * @return
     */
    Map<Integer, Integer> getMapWithCounts();
}
