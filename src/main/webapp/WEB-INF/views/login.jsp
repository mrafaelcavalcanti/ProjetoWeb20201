<%@page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
lang="en">

<head>

    <link th:href="@{/webjars/bootstrap/css/bootstrap.min.css}" rel="stylesheet"/>

    <link th:href="@{/webjars/bootstrap/css/bootstrap-theme.min.css}" rel="stylesheet"/>

    <link th:href="@{/webjars/font-awesome/css/font-awesome.min.css}" rel="stylesheet"/>

    <link th:href="@{/css/style.css}" rel="stylesheet"/>
    
    <!-- Custom fonts for this template-->

    <link rel="stylesheet" href="resources/css/loginCSS.css">
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
    <script src="resources/js/loginJS.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    
    <meta name="description" content="">
    <meta name="author" content="">

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PROJETO WEB</title>
   
    
</head>
<body class="fundo">
    
    <div class="home-page">
        
        <div class="entrar">
            <div class="icone-sistema">
                <span class="iconify" data-icon="bi-flower1" data-inline="false" data-width="80"></span>
            </div>
            
            <div class="texto-entrar">
                <label id="bemvindo">Bem-Vindo de volta!</label>
                <label id="acessesuaconta">Acesse sua conta!</label>
            </div>
            
            <button id="entrar" class="entrar-btn" onclick="switchEntrarCadastrar(0)">ENTRE</button><!--Clicando nesse botao sera redirecionado para a pagina home da pagina-->
            <button id="cadastrese" class="entrar-btn inativo" onclick="switchEntrarCadastrar(1)">CADASTRE-SE</button><!--Atualmente nao faz nada ira funcionar quando for implementado o codigo para cadastro-->
        </div>
        <div class="entrar-shadow"></div>
        
        <div id="cadastrar" class="cadastrar" >
            <label class="title">cadastre-se</label>
            
            <input type="text" id="nomeUsuario" class="campo" placeholder="NOME">
            <input type="text" id="email" class="campo" placeholder="EMAIL">
            <input type="password" id="senha" class="campo" placeholder="SENHA">
            <input type="text" id="tipo_usuario_setado" hidden>
            
            <div class="botoes">
                <button class="produtor-btn" id="produtor" onclick="setTipoUsuario(0)">PRODUTOR</button>
                <button class="consumidor-btn" id="consumidor" onclick="setTipoUsuario(1)">CONSUMIDOR</button>
            </div>
            <button class="cadastrar-btn" onclick=cadastrar()>CADASTRAR</button>
        </div>

        <div id="entrar-page" class="entrar-page transicao inativo">
            <label class="title">realize seu login</label>
            <input type="text" id="emailLogin" class="campo" placeholder="EMAIL" value="">
            <input type="password" id="senhaLogin" class="campo" placeholder="SENHA" value="">
            <button class="entrar-login-btn highlight" onclick="entrar()">ENTRAR</button>
        </div>
    </div>



    <div class="form-cadastrar" hidden>
        
        <input type="text" id="tipoUsuarioCadastrar">
    </div>
    <div class="form-entrar" hidden>
        <div th:if="${param.error}"></div>

        <form class="user" action="/login" method="post">
            <div class="form-group">
                <input id="entrar-usuario-username" name="username" value=""/>
            </div>

            <div class="form-group">
                <input id="entrar-usuario-password" type="password" name="password" value=""/>
            </div>

            <div class="form-group">
                <button id="entrar-usuario-entrar">Entrar</button>
            </div>

            <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
        </form>
    </div>
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
</body>
</html>