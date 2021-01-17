<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<h1>Adding a New Article</h1>
	<form action="/article/saveArticle" modelAttribute="articleForm" method="post">
		<table>
			<tr>
				<td>Libelle</td>
				<td><input type="text" name="libelle" /></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><input type="number" name="prix" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><input type="number" name="quantite" /></td>
			</tr>
				<tr>
				<td>Etat</td>
				<td><input type="text" name="etat" /></td>
			</tr>
			
			
			
		</table>
		<input type="submit" value="Submit" />
	</form>

</body>
</html>