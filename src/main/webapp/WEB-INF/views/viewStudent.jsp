<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 31.10.16
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/studentList">К списку студентов</a>
<table>
    <tr>
        <td><label>Name:</label></td>
        <td>${studentName}</td>
    </tr>
    <tr>
        <td><label>Last name:</label></td>
        <td>${studentLastName}</td>
    </tr>

    <tr>
        <td><label>Sex:</label></td>
        <td>${studentSex}</td>
    </tr>
    <tr>
        <td><label>Birthday</label></td>
        <td>${studentBirthday}</td>
    </tr>
</table>
</body>
</html>
