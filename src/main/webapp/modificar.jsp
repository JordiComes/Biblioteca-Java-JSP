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

<% Libro libro = (Libro)request.getSession().getAttribute("producto");

%>

<form action="modificarPrecio" method="get">

<label>Titulo</label>
<input readonly value="<%= libro.getTitulo() %>" type="text" name="titulo">

<label>Editorial</label>
<input readonly value="<%= libro.getEditorial() %>" type="text" name="editorial">

<label>Autor</label>
<input readonly value="<%= libro.getAutor() %>" type="text" name="autor">

<label>Isbn</label>
<input readonly value="<%= libro.getIsbn() %>" type="text" name="isbn">

<label>Paginas</label>
<input readonly value="<%= libro.getN_paginas() %>" type="text" name="paginas">

<label>Precio</label>
<input value="<%= libro.getPrecio() %>" type="text" name="precio">

<input type="submit" id="submit" value="Modificar libro">


</form>



</body>
</html>