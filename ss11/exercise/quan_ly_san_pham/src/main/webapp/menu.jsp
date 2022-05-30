<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/29/2022
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h2>Menu</h2>
     <a href="/productServlet?action=displayProduct"><input type="submit" value="display" ></a>
    <a href="/productServlet?action=creatProduct"><input type="submit" value="creat product" ></a>


    <form action="/productServlet" method="get">
        <p>nhập tên sản phẩm muốn tìm </p>
        <input type="text" name="input">
        <input type="submit" name="action" value="search">
    </form>

</div>


</body>
</html>
