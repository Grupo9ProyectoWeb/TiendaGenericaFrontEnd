<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link rel="stylesheet" href="DiseñoB.css">
</head>
<body>
	<div class="men" align="left"><table class="menu" border="1">
	<tr><th scope="row"><a href="Usuario.jsp">Usuario</a></th><th><a href="Cliente.jsp">Cliente</a></th><th><a href="Proveedor.jsp">Proveedor</a></th><th><a href="Producto.jsp">Productos</a></th><th><a href="Ventas.jsp">Ventas</a></th><th><a href="Reportes.jsp">Reportes</a></th></tr>
</table></div><br>
	<div align="center"><form action="Resultados.jsp" method="post">
	<table><tr><td>Cedula:</td> <td><input type="text" name="txtCedulaCliente"></td><td><input type="submit" name="btnUsuConsultar" value=Consultar></td><td> Cliente:</td> <td> <output type="text" name="txtNombreCliente"></td><td>Consec:</td></td><output type="int" name="intConsecutivo"></td></tr>
		</table>
		</form>
		</div>
		<div align="left"><form action="Resultados.jsp" method="post">
		<table>
		<h2 align="left">Cod: Producto        Nombre Producto </h2>
		<tr><td><input type="text" name="txtCodProducto"></td><td><input type="submit" name="btnProConsultar" value="Consultar"></td></tr>		
		<tr><td><input type="text" name="txtCodProducto"></td><td><input type="submit" name="btnProConsultar" value="Consultar"></td></tr>
		<tr><td><input type="text" name="txtCodProducto"></td><td><input type="submit" name="btnProConsultar" value="Consultar"></td></tr>
		</table>
		</form>
		</div>
		
		

</body>
</html>