<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a>
<form action="addStudent" method="post">
    <table>
        <tr>
            <td><label>Name*:</label></td>
            <td><input type="text" name="studentName"/></td>
        </tr>
        <tr>
            <td><label>Last name:</label></td>
            <td><input type="text" name="studentLastName"/></td>
        </tr>

        <tr>
            <td>
                <label>Sex:</label>
            </td>
            <td>
                <select name="studentSex">
                    <option>G</option>
                    <option>M</option>
                </select></td>
        </tr>
        <tr>
            <td><label>Birthday</label></td>
            <td><input type="date" name="studentBirthday"/></td>
        </tr>
    </table>

    <input type="submit" value="add student"/>

</form>
</body>
</html>
