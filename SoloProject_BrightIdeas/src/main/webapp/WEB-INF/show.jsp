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
<title>ideas likes</title>
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
				<h5 class="card-title">${idea.user.userName}says:</h5>
				<p class="card-text">${idea.ideaDescription}</p>
			</div>
			<div>
				<h1>Pepole who liked this post:</h1>
				<div class="mx-4 my-5 p-3 w-75 overflow-auto" id="ideaTable">
					<table class="table">
    <thead>
        <tr>
            <th>User Name</th>
            <th>Alias</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="like" items="${idea.likes}">
            <tr>
                <td><c:out value="${like.user.userName}" /></td>
                <td><c:out value="${like.user.alias}" /></td>
                <!-- Delete Like functionality -->
              
                    <td>
                      <c:if test="${like.user.id == user.id}">
                        <form action="/ideas/${idea.id}/like/${like.id}/delete" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" class="btn btn-link" value="Delete Your Like">
                       
                        </form>
                         </c:if>
                    </td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>

				</div>





			</div>
		</div>
	</div>
</body>
</html>
