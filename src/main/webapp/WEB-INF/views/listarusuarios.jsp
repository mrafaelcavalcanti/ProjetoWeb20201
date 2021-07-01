<%@ page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Usuario</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>nome</th>
		            <th>email</th>
		            <th>senha</th>
		            <th>Deletar</th>
		            <th>Ver Palestras</th>
		</tr>
	        
	
		 <c:forEach var="usuario" items="${usuarios}">
		            <tr>
		                <td>${usuario.id}</td>
		                <td>${usuario.nome}</td>
		                <td>${usuario.endereco.cidade}</td>
		                
		                
		                <td><a href="/usuarios/update/${usuario.id}">Atualizar</a></td>
		                <td><a href="/usuarios/delete/${usuario.id}">Deletar</a></td>
		                <!--<td><a href="/usuarios/findpalestrasbyevento/${usuario.id}">Ver</a></td>--->
		            </tr>
		</c:forEach>

	
	</table>
	<h2>${errors}</h2>
	
	
	<a href="/usuarios/novo/">Adicionar Evento</a></td>
	
	
	
</body>


</html>