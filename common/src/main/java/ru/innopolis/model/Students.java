package ru.innopolis.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * модель студентов
 */
public class Students implements Serializable {
    private static final long serialVersionUID = -4815697192234009717L;
    private Integer studentId;
    private String name;
    private String lname;
    private String sex;
    private Date birthday;
    private Integer version;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
