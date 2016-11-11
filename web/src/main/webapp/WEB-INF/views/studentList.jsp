<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a>
<form action="filter" method="post">
    <td><input type="text" name="filterByName"/></td>
    <td><input type="submit" name="filter" value="Filter by name"/></td>
</form>
<c:if test="${!empty list}">
    <table class="item-table">
        <tr>
            <th>Name</th>
            <th>Last name</th>
            <th>Sex</th>
            <th>Birthday</th>
            <th>Count lessons visit</th>
            <th>View link</th>
            <th>Update link</th>
            <th>Delete link</th>
        </tr>
        <tr>
            <td><a href="/sortStudent/name">sort by name</a></td>
            <td><a href="/sortStudent/lname">sort by lname</a></td>
            <td><a href="/sortStudent/sex">sort by sex</a></td>
            <td><a href="/sortStudent/birthday">sort by birthday</a></td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.lname}</td>
                <td>${item.sex}</td>
                <td>${item.birthday}</td>
                <%--<td>${mapWithCounts[(item.studentId).intValue()]}</td>--%>
                <td><a href="/viewStudent/${item.studentId}">view</a></td>
                <td><a href="/updateStudent/${item.studentId}">update</a></td>
                <td><a href="/deleteStudent/${item.studentId}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/addStudent">Добавить студента</a>
</body>
</html>