<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 31.10.16
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello <security:authentication property="principal.username" />!
<a href="/studentList">Список студентов</a>
<a href="/lessonList">Список лекций</a>
<a href="/studentWithLesson">Связь</a>
<a href="/j_spring_security_logout">exit</a>
</body>
</html>
