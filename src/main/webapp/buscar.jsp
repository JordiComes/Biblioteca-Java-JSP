<%@ page import="negocio.*" %>
<%@ page import="libreria.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>

<a href="carrito.jsp">ver carrito</a>

<form action="buscar" method="get"  >

<label>Titulo</label>
<input type="text" name="titulo">

<label>Isbn</label>
<input type="text" name="isbn">

<input type="submit" id="submit" value="Buscar libro">


</form>



</body>
</html>