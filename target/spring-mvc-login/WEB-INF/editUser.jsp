<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 15/12/16
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit user:</h1>
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

        <input type ="submit" value="Submit"/>
    </form:form>
    <div style="color:red">${error}</div>
</div>
</body>
</html>
