<%--
  Created by IntelliJ IDEA.
  User: Quoc Trung
  Date: 5/31/2022
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>

</head>
<body>
<table style="margin-left: 30%" border="1">
    <tr>
        <th colspan="6" style="text-align: center"><a href="/userControl?action=creat">Create</a></th>
    </tr>
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
            <td><a href="/userControl?action=update&id=${temp.id}">update</a></td>
                <%--            <td><a href="/userControl?action=delete&id=${temp.id}">delete</a></td>--%>
            <td>
                <button onclick="showInfo('${temp.id}','${temp.name}')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    delete
                </button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <form action="/userControl" method="get">
            <td colspan="2">searchUserByCountry</td>
            <td colspan="2"><input name="country" type="text"></td>
            <td><input name="action" type="submit" value="search"></td>
            <td><button class="btn btn-primary " style="width: 70px" type="submit" name="action" value="sort">Sort</button></td>
        </form>
    </tr>

</table>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form action="/userControl?action=delete" method="post">
        <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input  name="id" id="idUser" readonly>
                    <span>ban co muon xoa </span>
                    <span id="nameUser"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
        </div>
        </form>
    </div>
</div>
<script>
    function showInfo(id, name) {
        document.getElementById("nameUser").innerText = name;
        document.getElementById("idUser").value = id;

    }
</script>
</body>
</html>
