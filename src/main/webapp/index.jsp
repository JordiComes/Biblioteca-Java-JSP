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
		$('#submit').click(function(event) {
			event.preventDefault;
			var Titulo = $('#titulo').val();
			var Editorial = $('#editorial').val();
			var Autor = $('#autor').val();
			var Isbn = $('#isbn').val();
			var Paginas = $('#paginas').val();
			var Precio = $('#precio').val();
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.get('index', {
				titulo : Titulo,
				editorial : Editorial,
				autor : Autor,
				isbn : Isbn,
				paginas : Paginas,
				precio : Precio
			}, function(responseText) {
				/*$('#tabla').html(responseText);*/
				console.log(responseText);
				location.reload();
			});
		});
	});
	function borrarLibro(isbn) {
		console.log(isbn);
		$.get('eliminar', {
			
			isbn : isbn
			
		}, function(responseText) {
			/*$('#tabla').html(responseText);*/
			console.log(responseText);
			location.reload();
		});
		}
	
	function insertarCarrito (isbn) {
		console.log(isbn);
		$.get('insertarCarrito', {
			
			isbn : isbn
			
		}, function(responseText) {
			/*$('#tabla').html(responseText);*/
			console.log(responseText);
			
		});
	}
</script>
</head>
<body>

<a href="carrito.jsp">ver carrito</a>
<a href="buscar.jsp">Buscar</a>

<form class="formulario">

<label>Titulo</label>
<input type="text" id="titulo">

<label>Editorial</label>
<input type="text" id="editorial">

<label>Autor</label>
<input type="text" id="autor">

<label>Isbn</label>
<input type="text" id="isbn">

<label>Paginas</label>
<input type="text" id="paginas">

<label>Precio</label>
<input type="text" id="precio">

<input class="boton" type="button" id="submit" value="Añadir libro">


</form>


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

<% for(int i = 0; i < libreria1.getLibros().size(); i+=1) { %>
        <tr>      
            <td><%= libreria1.getLibros().get(i).getTitulo() %> </td>
             <td><%= libreria1.getLibros().get(i).getEditorial() %> </td>
              <td><%= libreria1.getLibros().get(i).getAutor() %> </td>
               <td><%= libreria1.getLibros().get(i).getIsbn() %> </td>
                <td><%= libreria1.getLibros().get(i).getN_paginas() %> </td>
                 <td><%= libreria1.getLibros().get(i).getPrecio() %> </td>
                 <td><button onclick="borrarLibro(<%= libreria1.getLibros().get(i).getIsbn() %>)">delete</button> </td>
                 <td><button onclick="insertarCarrito(<%= libreria1.getLibros().get(i).getIsbn() %>)">Añadir al carrito</button> </td>
        </tr>
    <% } %>
</table>

</body>
</html>