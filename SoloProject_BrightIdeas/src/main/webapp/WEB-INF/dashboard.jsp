<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<link href='https://fonts.googleapis.com/css?family=Press Start 2P'
	rel='stylesheet'>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container vh-100">
		<div class="d-flex flex-column">
			<div class="align-self-left">
				<h1>Welcome, ${user.userName}!</h1>
			</div>
			<div class="align-self-left">
				<h2>
					<a href="/logout">Logout</a>
				</h2>
			</div>
		</div>

		<form:form action="/ideas/new/idea" method="POST"
			modelAttribute="newIdea"
			class="h-25 w-100 d-flex flex-column justify-content-evenly">
			<div class="row mb-3">
				<form:label path="ideaDescription"
					class="col-sm-2 col-form-label mx-2"></form:label>
				<div class="col-sm-9">
					<form:input type="text" class="form-control" path="ideaDescription" />
				</div>
			</div>
			<div class="row mb-1">
				<form:errors path="ideaDescription" class="text-danger" />
			</div>


			<button type="submit" class="btn btn-success goButton">Idea!</button>
		</form:form>
		<div class="container vh-100">

			<div class="row">
				<c:forEach var="idea" items="${ideas}">
					<div class="col-12 mb-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title"><a  href="/users/${idea.user.id}">${idea.user.userName}</a> says:</h5>
								<p class="card-text">${idea.ideaDescription}</p>
							</div>
							<div class="card-footer">

								<form:form action="/ideas/${idea.id}/addlike" method="POST"
									modelAttribute="newLike"
									class="h-25 w-100 d-flex flex-column justify-content-evenly">

									<button type="submit">Like</button>
								</form:form>
								 <c:if test="${idea.user.id == user.id}">
                        <form action="/${idea.id}/delete" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" class="btn btn-link" value="Delete Your Post">
                       
                        </form>
								</c:if>
								
								
								<small class="text-muted"> <span class="likes-count"><a href="/ideas/view/${idea.id}">${idea.likes.size()} people</a></span>
									 like this.
								</small>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
