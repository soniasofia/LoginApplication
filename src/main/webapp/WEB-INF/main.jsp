<%@ page import="org.academiadecodigo.Model.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 08/12/16
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1>${greeting}</h1>
<h2>User management:</h2>

<div>
    <form:form method="post" modelAttribute="user">
        <p>Name:
            <form:input path="userName"/>
        <form:errors style ="color:red" path = "userName"/>
        Password:
            <form:password path="password"/>
        <form:errors style ="color:red" path = "password"/>
        Email:
            <form:input path="email"/></p>

        <input type ="submit" value="Add User">
        <p>${addedUser} ${removedUser}</p>
    </form:form>

    <div style="color:red">${error}</div>
</div>

<h3>List  Users</h3>
<c:if test="${not empty userList}">
    <ul>
        <c:forEach var="user" items="${userList}">
            <li> ${user.userName}:${user.email} <button style="background-color: white"><a href="user/remove/${user.userName}">Delete</a></button><button style="background-color: white"><a href="user/edit/${user.userName}">Edit</a></button></li>
        </c:forEach>
    </ul>
</c:if>
<h4><button style="background-color: white"><a href="user/logout">Logout</a></button></h4>
</body>
</html>
