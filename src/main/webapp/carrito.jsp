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
<script>
	$(document).ready(function() {
		
	});
	function borrarLibro(isbn) {
		console.log(isbn);
		$.get('eliminarCarrito', {
			
			isbn : isbn
			
		}, function(responseText) {
			/*$('#tabla').html(responseText);*/
			console.log(responseText);
			location.reload();
		});
		}
</script>
</head>
<body>

<a href="index.jsp">Volver al Inicio</a>


<%

GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
if (libreria1 == null) {
	 libreria1 = new GestorLibreria();

}
Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
if (carrito == null) {
	
	carrito = new Carrito();
}

%>
<table>

<% for(int i = 0; i < carrito.getLibros().size(); i+=1) { %>
        <tr>      
            <td><%= carrito.getLibros().get(i).getTitulo() %> </td>
             <td><%= carrito.getLibros().get(i).getEditorial() %> </td>
              <td><%= carrito.getLibros().get(i).getAutor() %> </td>
               <td><%= carrito.getLibros().get(i).getIsbn() %> </td>
                <td><%= carrito.getLibros().get(i).getN_paginas() %> </td>
                 <td><%= carrito.getLibros().get(i).getPrecio() %> </td>
                 <td><button onclick="borrarLibro(<%= carrito.getLibros().get(i).getIsbn() %>)">delete</button> </td>
        </tr>
    <% } %>
</table>

total: <%= carrito.verImporte() %>


</body>
</html>