package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Entidad.UsuarioDTO;
import Modelo.UsuarioDAO;

@WebServlet("/ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
}
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}
@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String u,c,r,e;
	int d;
	String res;
	UsuarioDTO usdto;
	UsuarioDAO usdao;
	UsuarioDTO recdatos;
	
	if(request.getParameter("btnins")!=null) {
	d=Integer.parseInt(request.getParameter("txtCedulaUsuario"));
	u=request.getParameter("txtUsuario");
	c=request.getParameter("txtPasswordUsuario");
	r=request.getParameter("txtNombreUsuario");
	e=request.getParameter("txtEmailUsuario");
	
	usdto=new UsuarioDTO(d, u, c, r, e);
	usdao=new UsuarioDAO();
	res=usdao.insertarusuario(usdto);
	if(res.equals("res,d")) {
		JOptionPane.showMessageDialog(null, "Usuario registrado", res, d);
		response.sendRedirect("Usuario.jsp");
	}
	else {
		JOptionPane.showMessageDialog(null, "Usuario registrado");
		response.sendRedirect("Usuario.jsp");
	}
			
	}
	
	if(request.getParameter("btncon")!=null){
	//Acci???n para consultar
	 int doc;
	 
	 d=Integer.parseInt(request.getParameter("txtCedulaUsuario"));
	 usdto=new UsuarioDTO(d);
	 usdao=new UsuarioDAO();
	 recdatos=usdao.consultarusuario(usdto);
	 doc=recdatos.getDocumento();
	 u=recdatos.getNomcompleto();
	 c=recdatos.getClave();
	 r=recdatos.getUsuario();
	 e=recdatos.getEmail();
			 
	 response.sendRedirect("Usuario.jsp?txtCedulaUsuario="+doc+"&&txtUsuario="+u+"&&txtPasswordUsuario="+c+"&&txtNombreUsuario="+r+"&&txtEmailUsuario="+e);
		
	}	
	if(request.getParameter("btnact")!=null) {
		//Acci???n para actualizar un usuraio
	  boolean dat;
	  d=Integer.parseInt(request.getParameter("txtCedulaUsuario"));
	  u=request.getParameter("txtUsuario");
	  c=request.getParameter("txtPasswordUsuario");
	  r=request.getParameter("txtNombreUsuario");
	  e=request.getParameter("txtEmailUsuario");
	  JOptionPane.showMessageDialog(null, "DOCUMENTO"+d);
	  usdto=new UsuarioDTO(d, u, c, r, e);
	  usdao=new UsuarioDAO();
	  dat=usdao.actualizar(usdto);
		if(dat==true) {
			JOptionPane.showMessageDialog(null, "El usuario se actualizo");
			response.sendRedirect("Usuario.jsp");
		}
	  
		else {
			JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
		     response.sendRedirect("Usuario.jsp");
		
		}
		
		
	}
	
	if(request.getParameter("btneli")!=null) {
		//Acci???n para eliminar
		int y;
		d=Integer.parseInt(request.getParameter("txtCedulaUsuario"));
		 usdto=new UsuarioDTO(d);
		 usdao=new UsuarioDAO();
		 y=usdao.eliminar(usdto);
		 if(y>0) {
		    JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
		    response.sendRedirect("Usuario.jsp");
			 
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "El usuario NO fue eliminado");
			 response.sendRedirect("Usuario.jsp");
		 }
		
		
		
	}
	
	ArrayList<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
	usdao=new UsuarioDAO();
	lista=usdao.consultar();
	 try ( PrintWriter out = response.getWriter()) {
	 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
	 }
	
	
	
}
	

}
