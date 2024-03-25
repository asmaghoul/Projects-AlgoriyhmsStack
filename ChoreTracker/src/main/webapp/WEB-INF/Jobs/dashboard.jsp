<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chore Tracker Dashboard</title>
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid mt-3">
		<div class="row p-4">
			<div class="col-sm-10 ">
				<div class="d-flex align-items-center">
					<h3 class="mr-5 mb-0">welcome, ${loggedUser.getFirstName() }!</h3>
					<a href="/logout" class="btn btn-danger">Logout</a>
				</div>
			</div>
			<div class="col-sm-2 ">
				<a href="/addJob" class="btn btn-primary mr-2">Add A Job</a>

			</div>
		</div>

		<div class="row p-4">
		    <div class="col-sm-8">
		    <table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Job</th>
					<th>Location</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="job" items="${allJobs}">

					<tr>
						<td>${job.title}</td>

						<td>${job.location}</td>
						<td><a href="view/${job.id}" class="btn btn-primary">View</a>
							<c:if test="${loggedUser.id!=job.createdBy.id}">
								<a href="joinJob/${job.id}" class="btn btn-success">add</a>
							</c:if> <c:if test="${loggedUser.id==job.createdBy.id}">
								<a href="edit/${job.id}" class="btn btn-primary">edit</a>
								<a href="delete/${job.id}" class="btn btn-danger">cancel</a>
							</c:if></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		    
		    </div>
		    <div class="col-sm-4">
		    
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>

					<th>My Jobs</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="job" items="${pickedJobs}">
					<c:if
						test="${job.pickedBy != null && job.pickedBy.id == loggedUser.id}">
						<tr>
							<td>${job.title}<a href="view/${job.id}"
								class="btn btn-primary">View</a> <a href="delete/${job.id}"
								class="btn btn-danger">Done</a>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		    </div>
		</div>
	</div>
	


</body>
</html>