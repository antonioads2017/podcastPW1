<%--
  Created by IntelliJ IDEA.
  User: CentroADM
  Date: 18/11/2018
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <table border="2px" >
            <tr>
                <th>Login</th>
                <th>Nome</th>
                <th>Idade</th>
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.login}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.idade}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
