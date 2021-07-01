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
    
<title>Pagina do usuario</title>

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
            <label for="tipo_usuario">tipo de usuario</label>
            <label for="tipo_usuario_0">Produtor</label>
            <form:radiobutton path="tipoUsuario" name="tipo_usuario" id="tipo_usuario_0" value="0"/>
            <label for="tipo_usuario_1">Consumidor</label>
            <form:radiobutton path="tipoUsuario" name="tipo_usuario" id="tipo_usuario_1" value="1"/>
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
            <label for="cidade">cidade</label>
            <form:input path="endereco.cidade" name="cidade" id="cidade"/>
        </div>

        <div>
            <input type="submit" value="Enviar">
        </div>
        
    </form:form>
    
	
    <form:hasBindErrors name="usuarioForm">
        <ul>
            <c:forEach var="error" items="${errors.allErrors}">
                <li>${error.code}</li>
            </c:forEach>
        </ul>
    </form:hasBindErrors>
    
	
	
</body>


</html>