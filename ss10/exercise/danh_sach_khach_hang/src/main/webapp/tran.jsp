<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/27/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div style="border: black solid 2px ; width: 300px" >
    <table border="1"  style="border: darkcyan" >
        <tr>
            <th>Name</th>
            <th>Date of birth</th>
            <th> Address</th>
            <th> img</th>
        </tr>
        <c:forEach items="${listCustomer}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.date}</td>
                <td>${item.address}</td>
                <td><img style="width: 100px ; height: 100px" src="${item.img}" alt=""></td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
