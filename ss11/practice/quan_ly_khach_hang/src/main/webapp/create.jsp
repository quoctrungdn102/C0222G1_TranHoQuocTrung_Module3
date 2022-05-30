<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/29/2022
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/customerServlet" method="post" style="display: flex">
        <div style="font-size: 18px">
            <lebal>id</lebal><br>
            <lebal>name</lebal><br>
            <lebal>email</lebal><br>
            <lebal>address</lebal><br>
        </div>
        <div>
            <input name="id" type="number"><br>
            <input name="name" type="text"><br>
            <input name="email" type="text"><br>
            <input name="address" type="text"><br>
            <input type="submit" name="action" value="create">
        </div>
    </form>



</body>
</html>
