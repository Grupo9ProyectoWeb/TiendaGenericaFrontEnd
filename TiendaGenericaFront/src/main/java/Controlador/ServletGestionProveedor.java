package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Entidad.ProveedorDTO;
import Modelo.ProveedorDAO;

public class ServletGestionProveedor extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProveedor() {
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
	ProveedorDTO prdto;
	ProveedorDAO prdao;
	ProveedorDTO recdatos;
	
	if(request.getParameter("btnins")!=null) {
	d=Integer.parseInt(request.getParameter("txtNITProveedor"));
	u=request.getParameter("txtTelefonoProveedor");
	c=request.getParameter("txtCiudadProveedor");
	r=request.getParameter("txtNombreProveedor");
	e=request.getParameter("txtDireccionProveedor");
	
	prdto=new ProveedorDTO(d, u, c, r, e);
	prdao=new ProveedorDAO();
	res=prdao.insertarproveedor(prdto);
	if(res.equals("res,d")) {
		JOptionPane.showMessageDialog(null, "Proveedor registrado", res, d);
		response.sendRedirect("Proveedor.jsp");
	}
	else {
		JOptionPane.showMessageDialog(null, "Proveedor registrado");
		response.sendRedirect("Proveedor.jsp");
	}
			
	}
	
	if(request.getParameter("btncon")!=null){
	//Acci�n para consultar
	 int doc;
	 
	 d=Integer.parseInt(request.getParameter("txtNITProveedor"));
	 prdto=new ProveedorDTO(d);
	 prdao=new ProveedorDAO();
	 recdatos=prdao.consultarproveedor(prdto);
	 doc=recdatos.getNIT();
	 u=recdatos.getNomcompleto();
	 c=recdatos.getTelefono();
	 r=recdatos.getCiudad();
	 e=recdatos.getDireccion();
			 
	 response.sendRedirect("Proveedor.jsp?txtNITProveedor="+doc+"&&txtCiudadProveedor="+u+"&&txtTelefonoProveedor="+c+"&&txtNombreProveedor="+r+"&&txtDireccionProveedor="+e);
		
	}	
	if(request.getParameter("btnact")!=null) {
		//Acci�n para actualizar un usuraio
	  boolean dat;
	  d=Integer.parseInt(request.getParameter("txtNITProveedor"));
	  u=request.getParameter("txtCiudadProveedor");
	  c=request.getParameter("txtTelefonoProveedor");
	  r=request.getParameter("txtNombreProveedor");
	  e=request.getParameter("txtDireccionProveedor");
	  JOptionPane.showMessageDialog(null, "DOCUMENTO"+d);
	  prdto=new ProveedorDTO(d, u, c, r, e);
	  prdao=new ProveedorDAO();
	  dat=prdao.actualizar(prdto);
		if(dat==true) {
			JOptionPane.showMessageDialog(null, "El proveedor se actualizo");
			response.sendRedirect("Proveedor.jsp");
		}
	  
		else {
			JOptionPane.showMessageDialog(null, "El proveedor no se actualizo");
		     response.sendRedirect("Proveedor.jsp");
		
		}
		
		
	}
	
	if(request.getParameter("btneli")!=null) {
		//Acci�n para eliminar
		int y;
		d=Integer.parseInt(request.getParameter("txtNITProveedor"));
		 prdto=new ProveedorDTO(d);
		 prdao=new ProveedorDAO();
		 y=prdao.eliminar(prdto);
		 if(y>0) {
		    JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
		    response.sendRedirect("Proveedor.jsp");
			 
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "El proveedor NO fue eliminado");
			 response.sendRedirect("Proveedor.jsp");
		 }
		
		
		
	}
	
	ArrayList<ProveedorDTO> lista=new ArrayList<ProveedorDTO>();
	prdao=new ProveedorDAO();
	lista=prdao.consultar();
	 try ( PrintWriter out = response.getWriter()) {
	 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
	 }
	
	
	
}
	

}
