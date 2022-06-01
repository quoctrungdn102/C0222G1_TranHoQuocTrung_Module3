<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>country</td>
    </tr>
    <c:forEach items="${list}" var="temp">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.name}</td>
            <td>${temp.email}</td>
            <td>${temp.country}</td>
        </tr>
    </c:forEach>

</table>
<h3>${mes}</h3>

</body>
</html>
