<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">На главную</a>
<form action="addStudent" method="post" name="studentForm">
    <input type="text" name="version" hidden>
    <table>
        <tr>
            <td><label>Name*:</label></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><label>Last name:</label></td>
            <td><input type="text" name="lname"/></td>
        </tr>

        <tr>
            <td>
                <label>Sex:</label>
            </td>
            <td>
                <select name="sex">
                    <option>G</option>
                    <option>M</option>
                </select></td>
        </tr>
        <tr>
            <td><label>Birthday</label></td>
            <td><input type="date" name="birthday"/></td>
        </tr>
    </table>

    <input type="submit" value="add student"/>

</form>
</body>
</html>
