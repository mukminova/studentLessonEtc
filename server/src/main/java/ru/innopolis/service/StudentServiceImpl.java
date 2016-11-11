package ru.innopolis.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.StudentsEntity;
import ru.innopolis.repository.StudentsRepository;
import ru.innopolis.model.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentsRepository studentsRepository;
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();


    @Override
    public Iterable<Students> getList() {
        mapperFactory.classMap(StudentsEntity.class, Students.class);
        List<StudentsEntity> studentsEntities = (List<StudentsEntity>) studentsRepository.findAll();
        List<Students> studentsModel = new ArrayList<>();
        for (StudentsEntity lesson : studentsEntities) {
            studentsModel.add(mapperFacade.map(lesson, Students.class));
        }
        return studentsModel;
    }


    @Override
    public void addStudent(Students student) {
        mapperFactory.classMap(Students.class, StudentsEntity.class);
        studentsRepository.save(mapperFacade.map(student, StudentsEntity.class));
    }

    @Override
    public Students getStudentById(Integer studentId) {
        mapperFactory.classMap(StudentsEntity.class, Students.class);
        StudentsEntity studentsEntity = studentsRepository.findOne(studentId);

        return mapperFacade.map(studentsEntity, Students.class);
    }

    @Override
    public void updateStudent(Students student) {
        mapperFactory.classMap(Students.class, StudentsEntity.class);
        studentsRepository.save(mapperFacade.map(student, StudentsEntity.class));
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        mapperFactory.classMap(StudentsEntity.class, Students.class);
        studentsRepository.delete(studentId);
    }

    @Override
    public List<Students> filterStudent(String name) {
        return null;
    }

    @Override
    public List<Students> sortStudentsByField(String sortField) {
        return null;
    }
}
