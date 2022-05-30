<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/29/2022
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>origin</th>
            <th>price</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.origin}</td>
            <td>${product.price}</td>
        </tr>
    </table>
    <p>${mes}</p>
    <button><a href="/menu.jsp"> return menu</a> </button>
</div>
</body>
</html>
