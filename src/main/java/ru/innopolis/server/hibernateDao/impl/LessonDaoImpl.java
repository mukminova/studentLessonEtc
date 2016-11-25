package ru.innopolis.server.hibernateDao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.LessonsEntity;
import ru.innopolis.server.hibernateDao.LessonDao;

import java.util.List;

@Component
public class LessonDaoImpl implements LessonDao {


    public List<LessonsEntity> getLessonList() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        List<LessonsEntity> lessonsEntities = (List<LessonsEntity>) session.createCriteria(LessonsEntity.class).list();
        session.close();
        return lessonsEntities;
    }

    @Override
    public LessonsEntity getLessonById(int lessonId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        LessonsEntity lessonsEntity = (LessonsEntity) session.load(LessonsEntity.class, lessonId);
        return lessonsEntity;
    }
}
