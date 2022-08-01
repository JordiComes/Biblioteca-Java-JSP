package libreria;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		  name = "modificarPrecio",
		  description = "JSP Servlet With Annotations",
		  urlPatterns = {"/modificarPrecio"}
		)
public class modificarPrecio extends HttpServlet{
	@Override
	  protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
		
		Integer Isbn=null;
		if (!request.getParameter("isbn").equalsIgnoreCase("")) {
					Isbn = Integer.parseInt(request.getParameter("isbn")); 

		
		}
		Double precio=null;
		if (!request.getParameter("precio").equalsIgnoreCase("")) {
					precio = Double.parseDouble(request.getParameter("precio")); 

		
		}
		 

		GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
		if (libreria1 == null) {
			 libreria1 = new GestorLibreria();

		}
		
		
		Libro libro = libreria1.buscarLibroPorIsbn(Isbn);
		libro.setPrecio(precio);
		
		
		
			response.sendRedirect("index.jsp");
		
		
		
	    
	   }
	
}
