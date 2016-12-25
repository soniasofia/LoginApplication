<%@ page import="org.academiadecodigo.Model.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="user">
    <p>Name:
        <form:input path="userName"/></p>
        <p><form:errors style ="color:red" path = "userName"/></p>
    <p>Password:
        <form:password path="password"/></p>
        <p><form:errors style ="color:red" path = "password"/></p>

    <input type="submit" value="Login"/>
    </form:form>
    <div style="color:red">${error}</div>
</div>
</body>
</html>

