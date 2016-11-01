package ru.innopolis.server.dao.impl;

import org.springframework.stereotype.Component;
import ru.innopolis.server.dao.StudentsDao;
import ru.innopolis.server.model.Students;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Li on 31.10.16.
 */
@Component
public class StudentsDaoImpl implements StudentsDao {
    public static final String URL = "jdbc:postgresql://localhost:5432/test_database";
    public static final String USER = "postgres";
    public static final String PWD = "";
    public static final String DRIVER_NAME = "org.postgresql.Driver";

    public List<Students> getAllStudents() throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM students");
            return getStudents(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStudent(Students student) {
        String name = student.getName();
        String lname = student.getLname();
        String sex = student.getSex();
        Date birthday = student.getBirthday();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            PreparedStatement ps = connection.prepareStatement("insert into students(name,lname,sex,birthday) VALUES (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, lname);
            ps.setString(3, sex);
            ps.setDate(4, birthday);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Students getStudentById(Integer studentId) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        Students student = new Students();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM students WHERE id ='" + studentId + "' ");
            while (rs.next()) {
                student.setName(rs.getString("name"));
                student.setLname(rs.getString("lname"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudent(Students student) {
        Integer id = student.getStudentId();
        String name = student.getName();
        String lname = student.getLname();
        String sex = student.getSex();
        Date birthday = student.getBirthday();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            PreparedStatement ps = connection.prepareStatement("UPDATE students SET name = ?, lname = ?, sex = ?, birthday = ? where id = ?");
            ps.setString(1, name);
            ps.setString(2, lname);
            ps.setString(3, sex);
            ps.setDate(4, birthday);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            statement.executeQuery("delete FROM students WHERE id ='" + studentId + "' ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Students> filterStudent(Students student) {
        String name = student.getName();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM students where name='" + name + "'");
            return getStudents(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Students> sortStudentsByField(String sortField) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM students order by " + sortField + "");
            return getStudents(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Integer> countVisitsWithStudentId() {
        Map<Integer, Integer> countWithStudentId = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT s.id, count(s.id) from lessons l\n" +
                    "LEFT JOIN students_lesson v on l.id = v.lesson_id\n" +
                    "LEFT JOIN students s on v.student_id = s.id\n" +
                    "GROUP BY s.id");
            while (rs.next()) {
                countWithStudentId.put(rs.getInt("id"), rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countWithStudentId;
    }

    private List<Students> getStudents(ResultSet rs) throws SQLException {
        List<Students> studentsList = new ArrayList<Students>();
        while (rs.next()) {
            Students student = new Students();
            student.setStudentId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setLname(rs.getString("lname"));
            student.setSex(rs.getString("sex"));
            student.setBirthday(rs.getDate("birthday"));
            studentsList.add(student);
        }
        return studentsList;
    }

}
