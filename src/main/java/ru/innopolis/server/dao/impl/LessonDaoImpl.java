package ru.innopolis.server.dao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.dao.LessonDao;
import ru.innopolis.server.model.Lessons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LessonDaoImpl implements LessonDao {
    public static final String URL = "jdbc:postgresql://localhost:5432/test_database";
    public static final String USER = "postgres";
    public static final String PWD = "";
    public static final String DRIVER_NAME = "org.postgresql.Driver";

    public List<Lessons> getLessonList() throws ClassNotFoundException {
        List<Lessons> lessonsList = new ArrayList<Lessons>();
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM lessons");
            while (rs.next()) {
                Lessons lesson = new Lessons();
                lesson.setLessonId(rs.getInt("id"));
                lesson.setTopic(rs.getString("topic"));
                lesson.setDescription(rs.getString("description"));
                lesson.setDuration(rs.getInt("duration"));
                lesson.setDate(rs.getDate("date"));
                lessonsList.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessonsList;
    }
}
