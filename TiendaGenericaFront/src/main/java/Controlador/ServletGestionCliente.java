package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Entidad.ClienteDTO;
import Modelo.ClienteDAO;

public class ServletGestionCliente extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionCliente() {
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
	ClienteDTO cldto;
	ClienteDAO cldao;
	ClienteDTO recdatos;
	
	if(request.getParameter("btnins")!=null) {
	d=Integer.parseInt(request.getParameter("txtCedulaCliente"));
	u=request.getParameter("txtDireccionCliente");
	c=request.getParameter("txtTelefonoCliente");
	r=request.getParameter("txtNombreCliente");
	e=request.getParameter("txtEmailCliente");
	
	cldto=new ClienteDTO(d, u, c, r, e);
	cldao=new ClienteDAO();
	res=cldao.insertarcliente(cldto);
	if(res.equals("res,d")) {
		JOptionPane.showMessageDialog(null, "Cliente registrado", res, d);
		response.sendRedirect("Cliente.jsp");
	}
	else {
		JOptionPane.showMessageDialog(null, "Cliente registrado");
		response.sendRedirect("Cliente.jsp");
	}
			
	}
	
	if(request.getParameter("btncon")!=null){
	//Acci�n para consultar
	 int doc;
	 
	 d=Integer.parseInt(request.getParameter("txtCedulaCliente"));
	 cldto=new ClienteDTO(d);
	 cldao=new ClienteDAO();
	 recdatos=cldao.consultarcliente(cldto);
	 doc=recdatos.getDocumento();
	 u=recdatos.getNomcompleto();
	 c=recdatos.getTelefono();
	 r=recdatos.getDireccion();
	 e=recdatos.getEmail();
			 
	 response.sendRedirect("Cliente.jsp?txtCedulaCliente="+doc+"&&txtDireccionCliente="+u+"&&txtTelefonoCliente="+c+"&&txtNombreCliente="+r+"&&txtEmailCliente="+e);
		
	}	
	if(request.getParameter("btnact")!=null) {
		//Acci�n para actualizar un usuraio
	  boolean dat;
	  d=Integer.parseInt(request.getParameter("txtCedulaCliente"));
	  u=request.getParameter("txtDireccionCliente");
	  c=request.getParameter("txtTelefonoCliente");
	  r=request.getParameter("txtNombreCliente");
	  e=request.getParameter("txtEmailCliente");
	  JOptionPane.showMessageDialog(null, "DOCUMENTO"+d);
	  cldto=new ClienteDTO(d, u, c, r, e);
	  cldao=new ClienteDAO();
	  dat=cldao.actualizar(cldto);
		if(dat==true) {
			JOptionPane.showMessageDialog(null, "El cliente se actualizo");
			response.sendRedirect("Cliente.jsp");
		}
	  
		else {
			JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
		     response.sendRedirect("Cliente.jsp");
		
		}
		
		
	}
	
	if(request.getParameter("btneli")!=null) {
		//Acci�n para eliminar
		int y;
		d=Integer.parseInt(request.getParameter("txtCedulaCliente"));
		 cldto=new ClienteDTO(d);
		 cldao=new ClienteDAO();
		 y=cldao.eliminar(cldto);
		 if(y>0) {
		    JOptionPane.showMessageDialog(null, "El cliente fue eliminado");
		    response.sendRedirect("Cliente.jsp");
			 
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "El cliente NO fue eliminado");
			 response.sendRedirect("Cliente.jsp");
		 }
		
		
		
	}
	
	ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
	cldao=new ClienteDAO();
	lista=cldao.consultar();
	 try ( PrintWriter out = response.getWriter()) {
	 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
	 }	
}
}
