<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
<link rel="stylesheet" href="DiseñoB.css">
</head>
<body>
	<h1 align="center">Tienda Generica</h1>
	<div class="men" align="left"><table class="menu" border="1">
	<tr><th scope="row"><a href="Usuario.jsp">Usuario</a></th><th><a href="Cliente.jsp">Cliente</a></th><th><a href="Proveedor.jsp">Proveedor</a></th><th><a href="Producto.jsp">Productos</a></th><th><a href="Ventas.jsp">Ventas</a></th><th><a href="Reportes.jsp">Reportes</a></th></tr>
	</table></div><br>
	<div align="center"><form action="Resultados.jsp" method="post">	
		<table><tr><td>Nombre del Archivo:</td> <td><input type="csv" name="csvNombreArchivo"></td> <td></td><td><input type="submit" name="btnExaminar" value=Examinar></tr>
		<tr></tr>
		<tr><td></td><td><input type="submit" name="btnCargar" value="Cargar"></td></tr>
	</table></form></div>

</body>
</html>