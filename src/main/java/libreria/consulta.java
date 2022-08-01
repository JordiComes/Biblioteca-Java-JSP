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
		  name = "buscar",
		  description = "JSP Servlet With Annotations",
		  urlPatterns = {"/buscar"}
		)
public class consulta extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
		
		Integer Isbn=null;
		if (!request.getParameter("isbn").equalsIgnoreCase("")) {
					Isbn = Integer.parseInt(request.getParameter("isbn")); 

		
		}
		
		String nombre = (request.getParameter("titulo")); 

		GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
		if (libreria1 == null) {
			 libreria1 = new GestorLibreria();

		}
		
		
		Libro libro = null;
		
		if (nombre!=null) {
			if (libreria1.getLibros().size()>0) {
				libro = libreria1.buscarLibroPorNombre(nombre);
				
			}
			
		}
		
		else {
			if (Isbn != null) {
				if (libreria1.getLibros().size()>0) {
					libro = libreria1.buscarLibroPorIsbn(Isbn);
			}
		}
		}
			if (libro!=null) {
				request.getSession().setAttribute("producto", libro);
			}
		
			response.sendRedirect("modificar.jsp");
		
		
		
	    
	   }
	
}

