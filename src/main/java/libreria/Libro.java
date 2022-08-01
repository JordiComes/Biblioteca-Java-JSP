package libreria;

public class Libro {

	private String titulo;
	private String editorial;
	private String autor;
	private int ISBN;
	private int n_paginas;
	private double precio;
	
	public Libro() {
	
	this.titulo = "";
	this.editorial = "";
	this.autor = "";
	this.ISBN = 0;
	this.n_paginas = 0;
	this.precio = 0.0;
	
	}
	
	public Libro(String titulo, String editorial, String autor, int iSBN, int n_paginas, double precio) {
		
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		ISBN = iSBN;
		this.n_paginas = n_paginas;
		this.precio = precio;
	}
public Libro(String titulo) {
		
		this.titulo = titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setIsbn(int ISBN) {
		this.ISBN = ISBN;
	}
	
	public int getIsbn() {
		return ISBN;
	}
	
	public void setN_paginas(int nPaginas) {
		this.n_paginas = nPaginas;
	}
	
	public int getN_paginas () {
		return this.n_paginas;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
}


