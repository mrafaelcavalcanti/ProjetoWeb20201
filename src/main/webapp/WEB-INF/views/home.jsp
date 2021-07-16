<%@page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="resources/css/homeCSS.css">
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
    <script src="/resources/js/homeJS.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

</head>
<body class="fundo">
    <div id="usuario-logado" hidden><%=request.getRemoteUser() %></div>
    
    <div class="top-bar">
        <div id="nome-usuario-logado" class="usuario">
            
        </div>
        
        <div class="barra-pesquisa">
            <input type="text" class="campo">
        </div>
        
        <div class="carrinho">
           <a href="/carrinho"><span class="iconify" data-icon="ant-design:shopping-cart-outlined" data-inline="false" data-width="70" data-height="70"></span></a>
        </div>
        <form action="/logout" method="post" class="navbar-form navbar-right">
            <button type="submit" class="btn btn-default">
                <span class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></span>
                Sair
            </button>
    
            <input type="hidden" th:name="${_csrf.parameterName}"
                th:value="${_csrf.token}" />
        </form>
    
    </div>
    
    <div class="corpo">
        
        <div class="menu-lateral">
            <div class="filtro-produtos">
                <a href="#all" onclick="pesquisarPorCategoria(-1)">Todos</a>
                <a href="#legumes" onclick="pesquisarPorCategoria(3)">Legumes</a>
                <a href="#verduras" onclick="pesquisarPorCategoria(2)">Verduras</a>
                <a href="#frutas" onclick="pesquisarPorCategoria(1)">Frutas</a>
                <a href="#hortalicas" onclick="pesquisarPorCategoria(4)">hortaliças</a>
                <a href="#peixes" onclick="pesquisarPorCategoria(5)">Peixes</a>
                <a href="#carnes" onclick="pesquisarPorCategoria(6)">Carnes</a>
                <a href="#queijos" onclick="pesquisarPorCategoria(7)">Queijos</a>
                <a href="#veganos" onclick="pesquisarPorCategoria(8)">Veganos</a>
            </div>
        </div>
        
        <div id="tela-produtos-id" class="tela-produtos">

        </div>

    </div>
</body>
</html>