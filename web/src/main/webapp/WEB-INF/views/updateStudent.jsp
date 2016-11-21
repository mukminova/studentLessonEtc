<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/studentList">К списку студентов</a>
<form action="${studentId}" method="post" name="studentForm">
    <input type="text" name="version" value="${student.version}" hidden>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="lname" value="${student.lname}"></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td>
                <select name="sex">
                    <option selected="selected"></option>
                    <option>G</option>
                    <option>M</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="birthday" value="${student.birthday}"></td>
        </tr>
    </table>

    <input type="submit" value="update"/>

</form>
</body>
</html>
