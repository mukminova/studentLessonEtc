package ru.innopolis.server.hibernateDao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.StudentsLessonEntity;
import ru.innopolis.server.hibernateDao.StudentLessonDao;


@Component
public class StudentLessonDaoImpl implements StudentLessonDao {


    @Override
    public void addStudentLesson(StudentsLessonEntity studentsLessonEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

//        Criteria criteria = session.createCriteria(cls);
//        criteria.setCacheable(true);

        session.beginTransaction();
        session.save(studentsLessonEntity);
        session.getTransaction().commit();
    }
}
