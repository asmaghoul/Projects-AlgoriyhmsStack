<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
    <title>Job Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-fluid mt-3">
        <div class="row p-4">
            <div class="col-sm-8">
             <h2>Add a Job</h2>
            </div>
            <div class="col-sm-4">
                <div class="d-flex align-items-center">
                    <a href="/dashboard" class="btn btn-primary mr-2">Back</a>
                    <a href="/logout" class="btn btn-danger">Logout</a>
                </div>
            </div>
         </div>
         <div class="row">
          <div class="col-sm-8 ">
           
        <form:form action="/jobs" method="post" modelAttribute="job">
                    <div  class="form-group row my-3">
                     <label for="title" class="col-sm-2 col-form-label">Title:</label>
                     <div class="col-sm-10">
                         <form:input path="title" class="form-control"/>
                        <form:errors path="title" class="text-danger"/>
                     </div>
                     </div>
                 <div  class="form-group row my-3">
                  <label for="description" class="col-sm-2 col-form-label">Description</label>
                   <div class="col-sm-10">
                   <form:errors path="description" class="text-danger"/>
                  <form:textarea path="description" class="form-control" rows="4"/>
                   </div>
                   
                </div>
                <div  class="form-group row my-3">
                  <label for="location"  class="col-sm-2 col-form-label">Location</label>
                  <div class="col-sm-10">
                   <form:errors path="location" class="text-danger"/>
                   <form:input path="location" class="form-control"/>
               </div>
               </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>  
          </div>
         </div>
        
    </div>
</body>
</html>
