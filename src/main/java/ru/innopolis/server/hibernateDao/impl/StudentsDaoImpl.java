package ru.innopolis.server.hibernateDao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.StudentsEntity;
import ru.innopolis.server.hibernateDao.StudentsDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Component
public class StudentsDaoImpl implements StudentsDao {
    public EntityManager em = HibernateUtil.getEm();


    @Override
    public List<StudentsEntity> getAllStudents() {
        Query namedQuery = em.createNamedQuery("StudentsEntity.getAll");
        return namedQuery.getResultList();
    }

    @Override
    public void addStudent(StudentsEntity student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public StudentsEntity getStudentById(Integer studentId) {
        return em.find(StudentsEntity.class, studentId);
    }

    @Override
    public void updateStudent(StudentsEntity student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        em.getTransaction().begin();
        em.remove(getStudentById(studentId));
        em.getTransaction().commit();
    }

    @Override
    public List<StudentsEntity> filterStudent(StudentsEntity student) {
        return null;
    }

    @Override
    public List<StudentsEntity> sortStudentsByField(String sortField) {
        return null;
    }

    @Override
    public Map<Integer, Integer> countVisitsWithStudentId() {
        return null;
    }
}
