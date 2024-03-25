<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%@ page isErrorPage="true" %>    
<h3>User registration</h3>
<form:form action="/register" method="post" modelAttribute="newUser">
    <div class="form-group">
        <form:label path="userName">Name</form:label>
        <form:errors path="userName" class="text-danger"/>
        <form:input path="userName" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="alias">Alias</form:label>
        <form:errors path="alias" class="text-danger"/>
        <form:input path="alias" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="email">email</form:label>
        <form:errors path="email"  class="text-danger"/>
        <form:input path="email" type="email" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label for="password" path="password">password</form:label>
        <form:errors path="password"  class="text-danger"/>
        <form:input path="password" type="password" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label for="" path="confirm">confirm</form:label>
        <form:errors path="confirm"  class="text-danger"/>     
        <form:input  path="confirm" type="password" class="form-control"/>
    </div>    

    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>  
<br/>
<h3>User login</h3>
<form:form action="/login" method="post" modelAttribute="newLogin">

    <div class="form-group">
        <form:label path="email">email</form:label>
        <form:errors path="email"  class="text-danger"/>
        <form:input path="email" type="email" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label for="password" path="password">password</form:label>
        <form:errors path="password"  class="text-danger"/>
        <form:input path="password" type="password" class="form-control"/>
    </div>
    

    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>  

</div>
</body>
</html>