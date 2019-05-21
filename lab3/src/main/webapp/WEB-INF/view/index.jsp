<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: slon10
  Date: 5/19/19
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="POST" action="math-operation" modelAttribute="inputDto">
    <form:input path="leftArg" placeholder="Left argument"/>
    <form:input path="rightArg" placeholder="Right argument"/>
    <input type="submit" name="addition" value="Add">
    <input type="submit" name="subtraction" value="Subtract">
    <input type="submit" name="division" value="Divide">
    <input type="submit" name="multiplication" value="Multiply">
</form:form>

</body>
</html>
