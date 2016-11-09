package ru.innopolis.server.hibernateDao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.HibernateUtil;
import ru.innopolis.server.entity.LessonsEntity;
import ru.innopolis.server.hibernateDao.LessonDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class LessonDaoImpl implements LessonDao {
    public EntityManager em = HibernateUtil.getEm();

    public List<LessonsEntity> getLessonList() {
        Query namedQuery = em.createNamedQuery("LessonsEntity.getAll");
        return namedQuery.getResultList();
    }

    @Override
    public LessonsEntity getLessonById(int lessonId) {
        return em.find(LessonsEntity.class, lessonId);
    }
}
