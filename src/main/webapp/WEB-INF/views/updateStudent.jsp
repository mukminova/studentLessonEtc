<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/studentList">К списку студентов</a>
<form action="${studentId}" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="studentName" value="${studentName}"></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="studentLastName" value="${studentLastName}"></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td>
                <select name="studentSex">
                    <option selected="selected"></option>
                    <option>G</option>
                    <option>M</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="studentBirthday" value="${studentBirthday}"></td>
        </tr>
    </table>

    <input type="submit" value="update"/>

</form>
</body>
</html>
