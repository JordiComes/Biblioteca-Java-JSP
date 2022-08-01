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
		  name = "ExampleThree",
		  description = "JSP Servlet With Annotations",
		  urlPatterns = {"/index"}
		)
public class index extends HttpServlet {

	@Override
	  protected void doGet(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
		String Titulo = request.getParameter("titulo");
		String Editorial = request.getParameter("editorial");
		String Autor = request.getParameter("autor");
		int Isbn = Integer.parseInt(request.getParameter("isbn")); 
		int Paginas = Integer.parseInt(request.getParameter("paginas")); 
		double Precio = Double.parseDouble(request.getParameter("precio"));
		
		GestorLibreria libreria1 = (GestorLibreria) request.getSession().getAttribute("libreria");
		if (libreria1 == null) {
			 libreria1 = new GestorLibreria();

		}
		

		Libro libro = new Libro(Titulo, Editorial, Autor, Isbn, Paginas, Precio); 


		libreria1.crearLibro(libro);
		
		
		
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	     request.getSession().setAttribute("libreria", libreria1);
	      out.println(libreria1.libros.size());
	     /* out.println(libro.getIsbn());*/
	     
	   }
	
}
