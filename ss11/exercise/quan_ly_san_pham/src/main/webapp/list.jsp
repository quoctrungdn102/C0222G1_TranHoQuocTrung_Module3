<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px " width="50%">
    <tr>
        <th colspan="6"> danh sách Product</th>
    </tr>
    <tr>
        <th>id</th>
        <th>name</th>
        <th> origin</th>
        <th> price</th>
        <th colspan="2"><a href="/productServlet?action=creatProduct">Create </a></th>
    </tr>
    <c:forEach items="${productList}" var="temp">
        <tr>
            <td>${temp.id}</td>
            <td><a href="/productServlet?action=view&id=${temp.id}">${temp.name}</a></td>
            <td>${temp.origin}</td>
            <td>${temp.price}</td>
            <td><a href="/productServlet?action=edit&id=${temp.id}">update</a></td>
            <td><a href="/productServlet?action=delete&id=${temp.id}">delete</a></td>
        </tr>

    </c:forEach>
</table>
<div style="text-align: center">
    <h3>${mes}</h3>
    <button><a href="/menu.jsp"> return menu</a> </button>
</div>



</body>
</html>
