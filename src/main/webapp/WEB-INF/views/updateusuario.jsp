<%@ page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta lang="pt-br">
    <meta charset="UTF-8">
    
<title>Listar Usuario</title>

</head>
<body>

	<h2>${msgs}</h2>
	
    <form:form method="POST" modelAttribute="usuarioForm" action="/usuarios/save">
        <form:hidden path="id"></form:hidden>
        <div>
            <label for="nome">Nome</label>
            <form:input path="nome" name="nome" id="nome"/>
        </div>
        <div>
            <label for="email">Email</label>
            <form:input path="email" name="email" id="email" />
        </div>
        <div>
            <label for="senha">Senha</label>
            <form:input path="senha" name="senha" id="senha"/>
        </div>
        <div>
            <label for="telefone">Telefone</label>
            <form:input path="telefone" name="telefone" id="telefone"/>
        </div>
        <div>
            
        </div>
        <div>
            <label for="numeroCartao">Numero do Cartão</label>
            <form:input path="numeroCartao" name="numeroCartao" id="numeroCartao"/>
        </div>
        <div>
            <label for="chavePix">Chave Pix</label>
            <form:input path="chavePix" name="chavePix" id="chavePix"/>
        </div>

        <div>
            <label for="id">cidade</label>
            <form:input path="endereco.cidade" name="id" id="id"/>
        </div>

        <div>
            <input type="submit" value="Enviar">
        </div>
        
    </form:form>
        

    
        <ul>
            <c:forEach var="error" items="${errors.allErrors}">
                <li>${error.code}</li>
            </c:forEach>
        </ul>
    
    
        
	
	
	<a href="/usuarios/novo/">Adicionar Evento</a></td>
	
	
	
</body>


</html>