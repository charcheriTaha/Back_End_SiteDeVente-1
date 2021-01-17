<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css "
	rel="Stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

	<div class="Container">
		<h2>Article List</h2>
		<table class="table table-striped" border="2">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Libelle</th>
				<th scope="row">Prix</th>
				<th scope="row">Quantité</th>
				<th scope="row">Etat</th>
			</thead>

			<tbody>
				<c:forEach items="${articlesList}" var="article">
					<tr>

						<td>${article.id }</td>
						<td>${article.libelle}</td>
						<td>${article.prix}</td>
						<td>${article.quantite}</td>
						<td>${article.etat}</td>


						<td><spring:url value="/article/updateArticle/${article.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>

						<td><spring:url
								value="/article//deleteArticle/${article.id }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/article/addArticle/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Article</a>

	</div>

	<form action="/article/searching list libelle" method="post">
		<table style="with: 50%">
			<tr>
				<td>Search by Etat</td>
				<td><input type="text" name="fn" value="${fn}" /></td>
				<td><input type="submit" value="search" /></td>

			</tr>
		</table>
	</form>



</body>
</html>