package ru.innopolis.server.dao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.dao.StudentLessonDao;

import java.sql.*;

@Component
public class StudentLessonDaoImpl implements StudentLessonDao {
    public static final String URL = "jdbc:postgresql://localhost:5432/test_database";
    public static final String USER = "postgres";
    public static final String PWD = "";
    public static final String DRIVER_NAME = "org.postgresql.Driver";

    @Override
    public void addStudentLesson(Integer studentId, Integer lessonId) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            PreparedStatement ps = connection.prepareStatement("insert into students_lesson(student_id, lesson_id) VALUES (?,?)");
            ps.setInt(1, studentId);
            ps.setInt(2, lessonId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
