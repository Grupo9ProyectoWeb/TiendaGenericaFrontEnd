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
	<div class="men" align="left"><table class="menu" border="1">
	<tr><th scope="row"><a href="Usuario.jsp">Usuario</a></th><th><a href="Cliente.jsp">Cliente</a></th><th><a href="Proveedor.jsp">Proveedor</a></th><th><a href="Producto.jsp">Productos</a></th><th><a href="Ventas.jsp">Ventas</a></th><th><a href="Reportes.jsp">Reportes</a></th></tr>
	</table></div><br>
	<div align="center"><form method="post" action= "/UploadCSVFile" enctype="multipart/form.data">	
		<table><tr><td>Nombre del Archivo:</td> <td><input type="file" name="file" accept=".csv"></td> <td></td><td><input type="submit" value="Cargar archivo"></tr>
		<tr></tr>
		
	</table></form></div>
	<div style="color: red">${errorCargaArchivo}</div>
	<div style="color: blue">${ArchivoCargado}</div>

</body>
</html>