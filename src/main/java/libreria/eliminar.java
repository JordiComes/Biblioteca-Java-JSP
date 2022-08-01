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
		  name = "Eliminar",
		  description = "JSP Servlet With Annotations",
		  urlPatterns = {"/eliminar"}
		)
public class eliminar extends HttpServlet {

	@Override
	  protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
		
		int Isbn = Integer.parseInt(request.getParameter("isbn")); 
		

		GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
		if (libreria1 == null) {
			 libreria1 = new GestorLibreria();

		}
		
		if (libreria1.getLibros().size()>0) {
			libreria1.eliminarLibro(Isbn);

	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      out.println("Libro eliminado");
		}
		
		
	    
	   }
	
}