<%@page import="br.edu.ufape.bcc.projetoweb20201.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuario</title>
    <link rel="stylesheet" href="resources/css/usuarioCSS.css">
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>
    <script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
    <script src="resources/js/usuarioJS.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
    <div id="usuario-logado" hidden><%=request.getRemoteUser() %></div>
    <div class="fundo">
    <div class="top-bar">
        <div class="usuario">
            <a href="/home">HOME</a>
        </div>
        
        <div class="barra-pesquisa">
            <input type="text" class="campo">
        </div>
        
        <div class="carrinho">
           <a href="/carrinho"><span class="iconify" data-icon="ant-design:shopping-cart-outlined" style="color: black;" data-inline="false" data-width="70" data-height="70"></span></a>
        </div>
    </div>
    <div class="cadastrar-produto inativa" id="fecharCadatroProduto">
        <div class="produto">
            <div class="close-icon">
                <button onclick="fecharCadatroProduto()" style="background-color: transparent; border: none;"><span  class="iconify" data-icon="akar-icons:circle-x" data-inline="false" data-width="40px"></span></button>
            </div>
            <div class="produto-form">
                <input id="nome-produto" class="inputs-user">NOME</input>
                <select name="categoria-select" id="categoria-produto" class="inputs-user">
                    <option value="1">Frutas</option>
                    <option value="2">Verduras</option>
                    <option value="3">Legumes</option>
                    <option value="4">hortaliças</option>
                    <option value="5">Peixes</option>
                    <option value="6">Carnes</option>
                    <option value="7">Queijos</option>
                    <option value="8">Veganos</option>
                </select>CATEGORIA
                <input id="peso-produto" class="inputs-user">PESO</input>
                <input id="quantidade-produto" class="inputs-user">QUANTIDADE</input>
                <input id="preco-produto" class="inputs-user">PREÇO</input>
                <!--input class="inputs-user">DETALHES PRODUTO 6</=input></br-->
                <button class="inputs-user" onclick="cadastrarProduto()">CADASTRAR</button>
            </div>
        </div>
    </div>
    <div class="config-usuario">
        <div class="profile-usuario">

            <!-- IMAGEM ESTATICA, DEVERIA SER SUBSTITUIDA PELA IMAGEM DO USUARIO MAS NAO ESTA SENDO USADO IMAGENS -->
            <div class="profile-picture" style="background-image: url(https://img.mfrural.com.br/api/image?url=https://s3.amazonaws.com/mfrural-produtos-us/235482-346662-1895889-mudas-de-morango-importadas-da-espanha-50.webp&width=800&height=480&mode=4);">
                
            </div>

            <div class="campos">
                <input id="nome" class="inputs-user" value="">NOME</input>
                <input id="email" class="inputs-user" value="">EMAIL</input>
                <input id="telefone" class="inputs-user" value="">TELEFONE</input>
                <input type="password" id="senha" class="inputs-user" value="">SENHA</input>
                <button class="inputs-user" onclick="atualizarDadosUsuario()">ATUALIZAR DADOS</button></br>
                <input id="tipo-usuario" class="inputs-user" value="" readonly></input>
            </div>

        </div>

        <div class="config-latera">
            <div class="config config-1">
                <div class="endereco-dados">
                    <input id="id-endereco" hidden value=""></input>
                    <input id="cidade-endereco" class="inputs-user" value="">CIDADE</input>
                    <input id="bairro-endereco" class="inputs-user" value="">BAIRRO</input>
                    <input id="rua-endereco" class="inputs-user" value="">RUA</input>
                    <input id="numero-endereco" class="inputs-user" value="">NUMERO</input>
                    <input id="complemento-endereco" class="inputs-user" value="">COMPLEMENTO</input>
                    <input id="cep-endereco" class="inputs-user" value="">CEP</input>
                </div>
            </div>

            <div class="config config-2">
                <label>CONFIGURAÇAO 1</label>
                <label>CONFIGURAÇAO 2</label>
                <label>CONFIGURAÇAO 3</label>
                <label>CONFIGURAÇAO 4</label>
                <label onclick="abrirCadastrarProduto()">CADASTRAR PRODUTO</label>
            </div>
        </div>
    </div>
    
    </div>

    
</body>
</html>