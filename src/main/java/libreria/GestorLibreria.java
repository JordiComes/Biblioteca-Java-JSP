package libreria;

import java.util.ArrayList;

public class GestorLibreria {
	ArrayList<Libro> libros;


public GestorLibreria() {
	super();
	libros=new ArrayList<Libro>();
}

public ArrayList<Libro> getLibros() {
	return libros;
}

public void crearLibro(Libro libro) {
	this.libros.add(libro);

}

public Libro buscarLibroPorIsbn(int isbn) {
	for(Libro libro:libros) {
		if (libro.getIsbn()==isbn) {
			return libro;
		}
	}
	
	return null;
}

public Libro buscarLibroPorNombre(String nombre) {
	for(Libro libro:libros) {
		if (libro.getTitulo().equals(nombre)) {
			return libro;
		}
	}
	
	
	return null;
}

public void eliminarLibro (int isbn) {
	Libro nombre=null;
	for(Libro libro:libros) {
		if (libro.getIsbn()==isbn) {
			nombre=libro;
		}
	}
	libros.remove(nombre);
}
public void modificarPrecioLibro (int isbn, double precio) {
	for(Libro libro:libros) {
		if (libro.getIsbn()==isbn) {
			libro.setPrecio(precio);
		}
	}
	
}
public void mostrarLibros () {
	for(Libro libro:libros) {
		System.out.println(libro.getTitulo());
	}
	
}
}


/* 3 Classes mas de .java
 * plantilla Eliminar, cambiar nombre, metodo.
 * Se van a llamar ConsultaIsbn, Consulta.nombres, ModificarPrecio
 * Crear clase plantilla index.java, se va a llamar añadirCarrito, tambien necesitaremos un Carrito.jsp copiar de index.jsp*/
