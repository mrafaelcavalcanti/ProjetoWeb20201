<%@page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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
<body>
    <div class="fundo">
    <div hidden><sec:authentication property="principal.email" /></div> <!-- COM ISSO AGORA É POSSIVEL SUSBSITUIR A CHAMADA DE USUARIO VIA API A CADA ACESSO A CADA PAGINA-->
    <div id="usuario-logado" hidden><%=request.getRemoteUser() %></div>
    
    <div class="top-bar">
        <div id="nome-usuario-logado" class="usuario">
            
        </div>
        
        <div class="barra-pesquisa">
            <input type="text" id="input-pesquisa" class="campo">
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

    <div class="detalhes-produto inativa" id="fecharDetalhesProduto">
        <div class="produtos">
            <div class="close-icon">
                <button onclick="fecharDetalhesProduto()" style="background-color: transparent; border: none;"><span  class="iconify" data-icon="akar-icons:circle-x" data-inline="false" data-width="40px"></span></button>
            </div>
            
            <div style="display: flex;">
                <div class="imagem-produto">
                    <img src="https://img.mfrural.com.br/api/image?url=https://s3.amazonaws.com/mfrural-produtos-us/235482-346662-1895889-mudas-de-morango-importadas-da-espanha-50.webp&width=800&height=480&mode=4" width="400" height="450">
                </div>
                <div class="produto-form">
                    <input id="id-produto" class="inputs-user" hidden></input>
                    <input id="nome-produto" class="inputs-user">NOME</input>
                    <input id="categoria-produto" class="inputs-user" value="" readonly style="text-align: center;">CATEGORIA</input>
                    <input id="peso-produto" class="inputs-user">PESO</input>
                    <input id="quantidade-produto" class="inputs-user">QUANTIDADE</input>
                    <input id="preco-produto" class="inputs-user">PREÇO</input>
                    <div>
                        <input id="quantidade-comprar" type="number" min="1" max="7" step="1" value="1" onclick="valorTotal()">
                        <label id="valor-total">TOTAL R$ 0</label>
                    </div>
                    <button class="inputs-produto" onclick="comprarProduto()">COMPRAR</button>
                    <div>
                        
                    </div>
                </div>
            </div>
        </div>
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
</div>
</body>
</html>