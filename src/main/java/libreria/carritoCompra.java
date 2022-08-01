package libreria;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import negocio.Carrito;
@WebServlet(
		  name = "insertarCarrito",
		  description = "JSP Servlet With Annotations",
		  urlPatterns = {"/insertarCarrito"}
		)
public class carritoCompra extends HttpServlet {

	@Override
	  protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
		
		int Isbn = Integer.parseInt(request.getParameter("isbn")); 
		

		GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
		if (libreria1 == null) {
			 libreria1 = new GestorLibreria();

		}
		Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
		if (carrito == null) {
			
			carrito = new Carrito();
		}
		
		if (libreria1.getLibros().size()>0) {
			Libro libro = libreria1.buscarLibroPorIsbn(Isbn);
		carrito.agregarLibro(libro);
	     request.getSession().setAttribute("carrito", carrito);


	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      out.println("Libro añadido al carrito");
		}
		
		
	    
	   }
	
}