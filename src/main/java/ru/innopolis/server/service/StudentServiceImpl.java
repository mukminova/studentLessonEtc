package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.StudentService;
import ru.innopolis.server.entity.StudentsEntity;
import ru.innopolis.server.hibernateDao.StudentsDao;

import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentsDao studentsDao;

    public List<StudentsEntity> getList() {
        return studentsDao.getAllStudents();
    }

    @Override
    public void addStudent(StudentsEntity student) {
        studentsDao.addStudent(student);
    }

    @Override
    public StudentsEntity getStudentById(Integer studentId) {
        return studentsDao.getStudentById(studentId);
    }

    @Override
    public void updateStudent(StudentsEntity student) {
        studentsDao.updateStudent(student);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentsDao.deleteStudentById(studentId);
    }

    @Override
    public List<StudentsEntity> filterStudent(StudentsEntity student) {
        return studentsDao.filterStudent(student);
    }

    @Override
    public List<StudentsEntity> sortStudentsByField(String sortField) {
        return studentsDao.sortStudentsByField(sortField);
    }

    @Override
    public Map<Integer, Integer> getMapWithCounts() {
        return studentsDao.countVisitsWithStudentId();
    }
}
