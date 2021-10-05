<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link rel="stylesheet" href="DiseñoB.css">
</head>
<body>
	<h1 align="center">Tienda Generica</h1>
	<div class="men" align="left"><table class="menu" border="1">
	<tr><th scope="row"><a href="Usuario.jsp">Usuario</a></th><th><a href="Cliente.jsp">Cliente</a></th><th><a href="Proveedor.jsp">Proveedor</a></th><th><a href="Producto.jsp">Productos</a></th><th><a href="Ventas.jsp">Ventas</a></th><th><a href="Reportes.jsp">Reportes</a></th></tr>
</table></div><br>
	<div align="center"><form action="Resultados.jsp" method="post">	
		<table><tr><td>Cedula:</td> <td><input type="text" name="txtCedulaCliente"></td> <td> Telefono:</td> <td> <input type="text" name="txtTelefonoCliente"></td></tr>
		<tr><td>Nombre Completo:</td> <td><input type="text" name="txtNombreCliente"></td> <td>Correo Electronico:</td> <td> <input type="text" name="txtEmailCliente"></td></tr>	
		<tr><td>Direccion:</td> <td><input type="text" name="txtDireccionCliente"></td></tr>
		<tr></tr>
		<tr><td></td><td><input type="submit" name="btnUsuConsultar" value=Consultar>
		<input type="submit" name="btnUsuCrear" value="Crear">
		<input type="submit" name="btnUsuaActualizar" value="Actualizar">
		<input type="submit" name="btnUsuEliminar" value="Borrar"></td></tr>
	</table></form></div>
</body>
</html>