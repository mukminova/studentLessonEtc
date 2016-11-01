package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.StudentService;
import ru.innopolis.server.dao.StudentsDao;
import ru.innopolis.server.model.Students;

import java.util.List;
import java.util.Map;

/**
 * Created by Li on 31.10.16.
 */
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentsDao studentsDao;

    public List<Students> getList() throws ClassNotFoundException {
        return studentsDao.getAllStudents();
    }

    @Override
    public void addStudent(Students student) {
        studentsDao.addStudent(student);
    }

    @Override
    public Students getStudentById(Integer studentId) throws ClassNotFoundException {
        return studentsDao.getStudentById(studentId);
    }

    @Override
    public void updateStudent(Students student) {
        studentsDao.updateStudent(student);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentsDao.deleteStudentById(studentId);
    }

    @Override
    public List<Students> filterStudent(Students student) {
        return studentsDao.filterStudent(student);
    }

    @Override
    public List<Students> sortStudentsByField(String sortField) {
        return studentsDao.sortStudentsByField(sortField);
    }

    @Override
    public Map<Integer, Integer> getMapWithCounts() {
        return studentsDao.countVisitsWithStudentId();
    }
}
