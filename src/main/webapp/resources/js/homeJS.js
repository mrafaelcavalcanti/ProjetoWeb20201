window.onload = function () {
    var id = document.getElementById("usuario-logado").textContent;
    var url = 'http://localhost:8080/api/usuarios/get/' + id;
    console.log(url);
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao obter usuario, status' + response.status);
            return response.json();
        }).then(function (data) {
            console.log(data);
            document.getElementById("nome-usuario-logado").innerHTML = '<a href="/usuario">' + data.nome + '</a>'
        })
        .catch(function (response) {
            console.error(error.message);
        });

        pesquisarPorCategoria(-1);
}

var pesquisarPorCategoria = function(categoriaPesquisada) {
    document.getElementById("tela-produtos-id").innerHTML = "";
    if (categoriaPesquisada == -1) {
        var url=  "http://localhost:8080/api/produtos/get/all"
    } else {
        var url = "http://localhost:8080/api/produtos/getByCategoria/"+categoriaPesquisada;
    }
    
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao pesquisar produtos, status' + response.status);
            return response.json();
        }).then(function (data) {
            if(data.length==0) {
                alert("Nenhum produto encontrado");
            }
            var produtos = "";
            for (var i = 0; i < data.length; i++) {
                   produtos = produtos + '<div class="produto">' +
                    '<div class="nome-produto">' +
                    '<label>' + data[i].nomeProduto + '</label>' +
                    '</div>' +
                    '<div class="imagens">' +
                    '<img src="https://img.mfrural.com.br/api/image?url=https://s3.amazonaws.com/mfrural-produtos-us/235482-346662-1895889-mudas-de-morango-importadas-da-espanha-50.webp&width=800&height=480&mode=4" width="300" height="350">' +
                    '</div>' +
                    '<div class="info-produto">' +
                    '<label>PRECO: R$'+data[i].preco+'KG </label>' +
                    '</div>' +
                    '</div>';
            }
            document.getElementById("tela-produtos-id").innerHTML = produtos;
        })
}