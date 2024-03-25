<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    
</head>
<body>
<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-sm-10">
         <div class="d-flex align-items-center justify-content-end">
           <a href="/dashboard" class="btn btn-primary mr-3">Back</a>
           <a href="/logout" class="btn btn-danger">Logout</a>
        </div>
       </div>
    </div>
    <div class="row ">
        <div class="col-sm-8">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">${job.title}</h5>
                    <p class="card-text">${job.description}</p>
                    <p class="card-text">Posted by: ${job.createdBy.firstName}</p>
                    <p class="card-text">Posted On: ${job.createdAt}</p>
                </div>
            </div>
        </div>
    </div>

<a href="/joinJob/${job.id}" class="btn btn-success">Add To My Jobs</a>
</div>
</body>
</html>
