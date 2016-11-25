package ru.innopolis.server.hibernateDao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.StudentsEntity;
import ru.innopolis.server.hibernateDao.StudentsDao;

import java.util.List;
import java.util.Map;

@Component
public class StudentsDaoImpl implements StudentsDao {


    @Override
    public List<StudentsEntity> getAllStudents() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StudentsEntity.class);
        criteria.setCacheable(true);

//        List<StudentsEntity> studentsEntities = (List<StudentsEntity>) session.createCriteria(StudentsEntity.class).list();
//        criteria.setCacheable(true);
        session.close();
        return criteria.list();
    }

    @Override
    public void addStudent(StudentsEntity student) {
//        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
//        Session session = sessions.openSession();
//        session.beginTransaction();
//        session.merge(student);
//        session.getTransaction().commit();
//        session.close();
    }

    @Override
    public StudentsEntity getStudentById(Integer studentId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        StudentsEntity studentsEntity = (StudentsEntity) session.load(StudentsEntity.class, studentId);
        return studentsEntity;
    }

    @Override
    public void updateStudent(StudentsEntity student) {
        addStudent(student);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(getStudentById(studentId));
        session.getTransaction().commit();
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
