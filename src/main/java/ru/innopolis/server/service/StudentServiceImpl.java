package ru.innopolis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.StudentService;
import ru.innopolis.server.entity.StudentsEntity;
import ru.innopolis.server.repository.StudentsRepository;

import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService {
    //    @Autowired
//    StudentsDao studentsDao;
    @Autowired
    StudentsRepository studentsRepository;

    public Iterable<StudentsEntity> getList() {
        return studentsRepository.findAll();
    }

    @Override
    public void addStudent(StudentsEntity student) {
        studentsRepository.save(student);
    }

    @Override
    public StudentsEntity getStudentById(Integer studentId) {
        return studentsRepository.findOne(studentId);
    }

    @Override
    public void updateStudent(StudentsEntity student) {
        studentsRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentsRepository.delete(studentId);
    }

    @Override
    public List<StudentsEntity> filterStudent(String name) {
        return studentsRepository.findByAndSort(name);
    }

    @Override
    public List<StudentsEntity> sortStudentsByField(String sortField) {
        return studentsRepository.findByAndSort(sortField);
    }

    @Override
    public Map<Integer, Integer> getMapWithCounts() {
        return null;
    }
}
