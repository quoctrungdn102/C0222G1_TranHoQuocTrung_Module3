<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    double rate = Double.parseDouble(request.getParameter("rate"));
    double usa = Double.parseDouble(request.getParameter("usa"));
    double vnd = rate*usa;
%>
<h2>rate:<%=rate%></h2>
<h2>tiền usa: <%=usa%></h2>
<h2> tiền vnd <%=vnd%></h2>

</body>
</html>
