package negocio;

import java.util.ArrayList;

import libreria.GestorLibreria;
import libreria.Libro;

public class Carrito {
	
	
	
	ArrayList<Libro> productos;
	
	public Carrito() {
		super();
		
		productos=new ArrayList<Libro>();
	}

	public ArrayList<Libro> getLibros() {
		return productos;
	}
	
public void agregarLibro(Libro libro) {
	productos.add(libro);
}

public double verImporte() {
	double importe=0;
	for (Libro libro: productos) {
		importe+=libro.getPrecio();
	}
	return importe;
}

public void eliminarLibro(Libro libro) {
	productos.remove(libro);
}

}


