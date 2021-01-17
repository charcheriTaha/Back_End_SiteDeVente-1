<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Updating Article Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylsheet"/>
<script src="../../webjars/bootstrp/4.0.0/css/bootstrap.min.css"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
   <h1>Updating the article: ${articleForm.id} ${articleForm.libelle}</h1>
     <form action="/article/saveArticle" modelAttribute="articleForm" method="post">
       <table style="with: 50%">
         <input type="hidden" name="id" value=${articleForm.id}>
        
         <tr>
         <td>Libelle</td>
           <td><input type="text" name="firstName" value="${articleForm.libelle}" /></td>
         </tr>
         
         <tr>
         <td>Prix</td>
           <td><input type="number" name="lastName" value="${articleForm.prix}" /></td>
         </tr>
         
         <tr>
         <td>Quantité</td>
          <td><input type="number" name="email" value="${articleForm.quantite}" /></td>
         </tr>
          <tr>
          <td>Etat</td>
          <td><input type="text" name="mobile" value="${articleForm.etat}" /></td>
         </tr>
         
        
      </table>
      <input type="submit" value="Submit" />
    </form>
</body>