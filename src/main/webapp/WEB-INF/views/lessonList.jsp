<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a>
<c:if test="${!empty list}">
    <table class="item-table">
        <tr>
            <th>Topic</th>
            <th>Description</th>
            <th>Duration</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.topic}</td>
                <td>${item.description}</td>
                <td>${item.duration}</td>
                <td>${item.date}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
