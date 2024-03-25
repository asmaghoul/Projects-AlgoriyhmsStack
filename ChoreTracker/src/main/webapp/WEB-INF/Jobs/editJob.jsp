<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
   
    <title>Edit Your Job Posting</title>
   
</head>
<body>
  <div class="container-fluid mt-3">
   <div class="row p-4">
            <div class="col-sm-8">
              <h3>Edit Your Job Posting</h3>
            </div>
            <div class="col-sm-4">
                <div class="d-flex align-items-center">
                    <a href="/dashboard" class="btn btn-primary mr-2">Back</a>
                    <a href="/logout" class="btn btn-danger">Logout</a>
                </div>
            </div>
   </div>
 <div class="row p-4">
    <form:form action="/edit/${job.id}" method="post" modelAttribute="job" class="col-md-6">
        <input type="hidden" name="_method" value="put">
        <div class="form-group row mb-3">
            <form:label path="title" class="col-sm-4 col-form-label">Title:</form:label>
            <div class="col-sm-8">
                <form:errors path="title" class="text-danger"/>
                <form:input path="title" id="title" class="form-control"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <form:label path="description" class="col-sm-4 col-form-label">Description:</form:label>
            <div class="col-sm-8">
                <form:errors path="description" class="text-danger"/>
                <textarea id="description" name="description" class="form-control">${job.description}</textarea>
            </div>
        </div>
        <div class="form-group row mb-3">
            <form:label path="location" class="col-sm-4 col-form-label">Location:</form:label>
            <div class="col-sm-8">
                <form:errors path="location" class="text-danger"/>
                <form:input path="location" id="location" class="form-control"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-8 offset-sm-4">
                <button type="submit" class="btn btn-dark">Submit</button>
            </div>
        </div>
    </form:form>  
</div>


    </div>
</body>
</html>
