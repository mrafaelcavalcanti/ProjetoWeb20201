var allProdutos = "";


function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function fecharDetalhesProduto() {
    document.getElementById("fecharDetalhesProduto").classList.add("transicao");
    document.getElementById("fecharDetalhesProduto").classList.remove("ativa");
    await sleep(300);
    document.getElementById("fecharDetalhesProduto").classList.add("inativa");
    document.getElementById("valor-total").innerHTML = "TOTAL R$ 0";
}

function abrirDetalhesProduto(id) {
    for (var i=0; i<allProdutos.length; i++) {
        if (id==allProdutos[i].id) {
            document.getElementById("id-produto").value = allProdutos[i].id;
            document.getElementById("nome-produto").value = allProdutos[i].nomeProduto;
            document.getElementById("categoria-produto").value = allProdutos[i].categoria;
            document.getElementById("peso-produto").value = allProdutos[i].peso;
            document.getElementById("preco-produto").value = allProdutos[i].preco;
            document.getElementById("quantidade-produto").value = allProdutos[i].quantidade;
            setMinMaxComprar(allProdutos[i].quantidade ,allProdutos[i].categoria);
        }
    }
    
    document.getElementById("fecharDetalhesProduto").classList.add("ativa");
    document.getElementById("fecharDetalhesProduto").classList.remove("inativa");
}

function valorTotal() {
        document.getElementById("quantidade-comprar").addEventListener("click", function() {
        document.getElementById("valor-total").innerHTML = "TOTAL R$ " + (document.getElementById("preco-produto").value * document.getElementById("quantidade-comprar").value);
    });
}

setMinMaxComprar = function(max, categoria) {
    var step = "";
    if (categoria == 1) {
        step = 0.5;
    } else {
        step = 1;
    }
    document.getElementById("quantidade-comprar").min = step;
    document.getElementById("quantidade-comprar").max = max;
    document.getElementById("quantidade-comprar").step = step;
    document.getElementById("quantidade-comprar").value = step;
}

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
            console.error(response.error.message);
        });

        pesquisarPorCategoria(-1);
        pesquisar();
}

var pesquisar = function() {
    const inputEle = document.getElementById('input-pesquisa');
    inputEle.addEventListener('keyup', function(e){
        var key = e.which || e.keyCode;
        if (key == 13) {
            pesquisarPorNome(this.value);
        }
    });
}

var pesquisarPorNome = function(nome) {
    var url = "http://localhost:8080/api/produtos/getByName/"+nome;
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao pesquisar produtos, status' + response.status);
            return response.json();
        }).then(function (data) {
            if(data.length==0) {
                alert("Nenhum produto encontrado");
            }
            allProdutos = data;
            var produtos = "";
            for (var i = 0; i < data.length; i++) {
                   produtos = produtos + '<div class="produto" onclick="abrirDetalhesProduto('+data[i].id+')">' +
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
            allProdutos = data;
            var produtos = "";
            for (var i = 0; i < data.length; i++) {
                   produtos = produtos + '<div class="produto" onclick="abrirDetalhesProduto('+data[i].id+')">' +
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

function comprarProduto() {
    var id_usuario = document.getElementById("usuario-logado").textContent;
    var id_produto = document.getElementById("id-produto").value;
    var quantidade = document.getElementById("quantidade-comprar").value;
    var nome = document.getElementById("nome-produto").value;
    var categoria = document.getElementById("categoria-produto").value;
    var peso = document.getElementById("peso-produto").value;
    var preco = document.getElementById("preco-produto").value;
    var quantidadeProduto = document.getElementById("quantidade-produto").value;
    var quantidadeFinal = quantidadeProduto - quantidade;
    postCarrinho(id_usuario, id_produto, quantidade);
    putProduto(id_produto, nome, categoria, peso, preco, quantidadeFinal, id_usuario);
}

var postCarrinho = function (id_usuario, id_produto, quantidade) {
    doPostCarrinho("http://localhost:8080/api/carrinho/", id_usuario, id_produto, quantidade);
}

function doPostCarrinho(url, id_usuario, id_produto, quantidade) {
    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            id: null,
            idUsuario: id_usuario,
            idProduto: id_produto,
            quantidade: quantidade
        }),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            if(data.lengt) {
                console.log(data);
                alert("Produto adicionado ao carrinho com sucesso");
            }
        })
}


function doPutProduto(url, id, nome, categoria, peso, preco, quantidade, id_usuario) {
    fetch(url, {
        method: 'PUT',
        body: JSON.stringify({
            id: id,
            nomeProduto: nome,
            quantidade: quantidade,
            peso: peso,
            preco: preco,
            categoria: categoria,
            usuario: id_usuario
            
        }),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    })
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            if(data.length) {
                console.log(data);
            }
        })
}
var putProduto = function (id, nome, categoria, peso, preco, quantidade, id_usuario) {
    doPutProduto('http://localhost:8080/api/produtos/', id, nome, categoria, peso, preco, quantidade, id_usuario);
}