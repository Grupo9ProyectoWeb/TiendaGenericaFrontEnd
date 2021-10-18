<%@page import="javax.swing.JOptionPane"%>
<%@page import="conexion.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios Tienda</title>
<link rel="stylesheet" href="DiseñoB.css">
</head>
<body>
<%
Conexion con=new Conexion();
con.getConexion();
String d="",u="",c="",r="",e="";
if(request.getParameter("doc")!=null){
d=request.getParameter("doc");
u=request.getParameter("us");
c=request.getParameter("cl");
r=request.getParameter("ro");
e=request.getParameter("es");
JOptionPane.showMessageDialog(null, d+u+c+r+e);
}
%>
	<div class="menu" align="left"><table class="menu" border="1">
<tr><th scope="row"><a href="Usuario.jsp">Usuario</a></th><th><a href="Cliente.jsp">Cliente</a></th><th><a href="Proveedor.jsp">Proveedor</a></th><th><a href="Producto.jsp">Productos</a></th><th><a href="Ventas.jsp">Ventas</a></th><th><a href="Reportes.jsp">Reportes</a></th></tr>
</table></div><br>

	<div align="center"><form action="ServletGestionUsuario" method="post">	
		<table><tr><td>Cedula:</td> <td><input type="text" name="txtCedulaUsuario"></td> <td> Usuario:</td> <td> <input type="text" name="txtUsuario"></td></tr>
		<tr><td>Nombre Completo:</td> <td><input type="text" name="txtNombreUsuario"></td> <td>Contraseña:</td> <td> <input type="text" name="txtPasswordUsuario"></td></tr>	
		<tr><td>Correo Electronico:</td> <td><input type="text" name="txtEmailUsuario"></td></tr>
		<tr></tr>
		<tr><td></td><td><input type="submit" name="btnUsuConsultar" value=Consultar>
		<input type="submit" name="btnUsuCrear" value="Crear">
		<input type="submit" name="btnUsuaActualizar" value="Actualizar">
		<input type="submit" name="btnUsuEliminar" value="Borrar"></td></tr>
		</table>
	</form> 
	</div>
	
	<%
		
	
	%>

</body>
</html>