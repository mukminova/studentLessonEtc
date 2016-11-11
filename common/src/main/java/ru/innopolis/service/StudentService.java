package  ru.innopolis.service;

import ru.innopolis.model.Students;

import java.util.List;
import java.util.Map;

/**
 * интерфейс сервиса студентов
 */
public interface StudentService {


    /**
     * получить список студентов
     *
     * @return
     */
    Iterable<Students> getList();

    /**
     * добавить студента
     *
     * @param student
     */
    void addStudent(Students student);

    /**
     * найти студента по ид
     *
     * @param studentId
     * @return
     */
    Students getStudentById(Integer studentId);

    /**
     * обновить данные студента
     *
     * @param student
     */
    void updateStudent(Students student);

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
    List<Students> filterStudent(String name);

    /**
     * сортировка студентов по заданному параметру
     *
     * @param sortField
     * @return
     */
    List<Students> sortStudentsByField(String sortField);

}
