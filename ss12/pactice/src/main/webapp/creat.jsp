<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/31/2022
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/userControl?action=creat" method="post">
    <h2>nhap thông tin new user</h2>
    <table>
<%--        <tr>--%>
<%--            <td>id</td>--%>
<%--            <td> <input type="text" name="id"></input></td>--%>
<%--        </tr>--%>
        <tr>
            <td>name</td>
            <td> <input type="text" name="name"></input></td>
        </tr>
        <tr>
            <td>email</td>
            <td> <input type="text" name="email"></input></td>
        </tr>
        <tr>
            <td>country</td>
            <td> <input type="text" name="country"></input></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form>


</body>
</html>
