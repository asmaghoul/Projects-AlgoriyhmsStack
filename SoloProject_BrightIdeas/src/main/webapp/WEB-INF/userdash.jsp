<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User ideas & likes</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<div class="container">


		<h3>
			<a href="/dashboard">Bright Ideas</a>
		</h3>
		<div class="align-self-left">
				<h2>
					<a href="/logout">Logout</a>
				</h2>
			</div>
		<div>
			<div class="card-body">
				<h5 class="card-title">${idea.user.userName}</h5>
				<h5 class="card-title">${idea.user.email}</h5>
			</div>
			<div>
				<h1>Total Number of posts:  ${user.ideas.size()}</h1>
				<h1>Total Number of likes:  ${user.likedideas.size()}</h1>

				</div>
			</div>
		</div>
	
</body>
</html>
