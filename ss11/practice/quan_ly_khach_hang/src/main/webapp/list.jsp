<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/29/2022
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<table border="1px " width="50%">
    <tr >
        <th colspan="6"> danh sách Custormer </th>
    </tr>
    <tr>
        <th>id</th>
        <th>name</th>
        <th> email</th>
        <th> address</th>
        <th colspan="2"><a href="/customerServlet?action=create">Create </a> </th>
    </tr>
    <c:forEach items="${CustomerList}" var="temp">
        <tr>
            <td>${temp.id}</td>
            <td><a href="/customerServlet?action=viewCustomer&id=${temp.id}">${temp.name}</a></td>
            <td>${temp.email}</td>
            <td>${temp.address}</td>
            <td><a href="/customerServlet?action=upDate&id=${temp.id}">update</a></td>
            <td><a href="/customerServlet?action=delete&id=${temp.id}">delete</a></td>
        </tr>

    </c:forEach>
</table>
<p>${mes}</p>

</body>
</html>
