<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/29/2022
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/productServlet" method="post" style="display: flex">
    <div style="font-size: 18px">
        <lebal>id</lebal><br>
        <lebal>name</lebal><br>
        <lebal>origin</lebal><br>
        <lebal>price</lebal><br>
    </div>
    <div>
        <input name="id" type="number"><br>
        <input name="name" type="text"><br>
        <input name="origin" type="text"><br>
        <input name="price" type="text"><br>
        <input type="submit" name="action" value="creat">
    </div>
</form>
</body>
</html>
