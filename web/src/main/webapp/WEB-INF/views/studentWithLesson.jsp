<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a>
<form action="addStudentLesson" method="post">

    <label>Student</label>
    <select name="studentId">
        <c:forEach items="${studentList}" var="item">
            <option value="${item.studentId}">${item.name} ${item.lname}</option>
        </c:forEach>
    </select>

    <label>Lesson</label>
    <select name="lessonId">
        <c:forEach items="${lessonList}" var="item">
            <option value="${item.lessonId}">${item.topic} ${item.date}</option>
        </c:forEach>
    </select>

    <input type="submit" value="add"/>
</form>
</body>
</html>
