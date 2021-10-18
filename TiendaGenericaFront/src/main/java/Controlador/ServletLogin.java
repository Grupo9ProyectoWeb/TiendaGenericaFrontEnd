package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidad.Login;
import Modelo.ModeloLogin;

@WebServlet("/usuario")
public class ServletLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if ("iniciarSesion".equals(tipo)) {
			this.iniciarSesion(request, response);
		} else if ("cerrarSesion".equals(tipo)) {
			this.cerrarSesion(request, response);
		}
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");

		ModeloLogin modelo = new ModeloLogin();
		Login login = modelo.iniciarSesion(nombre, clave);

		if (login == null) {
			request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
			request.getRequestDispatcher("Indice.html").forward(request, response);
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", login);
			response.sendRedirect("Usuario.jsp");
		}
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Iniciar sesion");
		request.getRequestDispatcher("Indice.html").forward(request, response);
	}

}
