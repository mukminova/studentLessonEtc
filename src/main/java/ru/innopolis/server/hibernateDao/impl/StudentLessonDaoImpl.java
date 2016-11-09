package ru.innopolis.server.hibernateDao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.StudentsLessonEntity;
import ru.innopolis.server.hibernateDao.StudentLessonDao;

import javax.persistence.EntityManager;


@Component
public class StudentLessonDaoImpl implements StudentLessonDao {
   public EntityManager em = HibernateUtil.getEm();

    @Override
    public void addStudentLesson(StudentsLessonEntity studentsLessonEntity) {
        em.getTransaction().begin();
        em.merge(studentsLessonEntity);
        em.getTransaction().commit();
    }
}
