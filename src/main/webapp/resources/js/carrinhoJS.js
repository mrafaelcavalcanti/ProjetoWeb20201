var carrinho = "";
var produtos = [];
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
            //document.getElementById("nome-usuario-logado").innerHTML = '<a href="/usuario">' + data.nome + '</a>'
        })
        .catch(function (response) {
            console.error(error.message);
        });
        carregarCarrinho(id);
        montarTabela();
}

//meu-carrinho

var carregarCarrinho = function(id) {
    var url = 'http://localhost:8080/api/carrinho/getById/' + id;
    console.log(url);
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao obter carrinho, status' + response.status);
            return response.json();
        }).then(function (data) {
            console.log(data);
            carrinho = data;
            for (var i = 0; i<data.length; i++) {
                pesquisarPorId(data[i].idProduto);
            }
            //document.getElementById("nome-usuario-logado").innerHTML = '<a href="/usuario">' + data.nome + '</a>'
        })
        .catch(function (response) {
            console.error(error.message);
        });
}

var pesquisarPorId = function(id) {
    var url = "http://localhost:8080/api/produtos/getById/"+id;
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao pesquisar produtos, status' + response.status);
            return response.json();
        }).then(function (data) {
            if(data.length==0) {
                alert("Nenhum produto encontrado");
            }
            produtos.push(data);
        })
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function montarTabela() {
    await sleep(300);
    var lista = "";
    for (var i = 0; i<produtos.length; i++) {
        for (var j = 0; j<carrinho.length; j++) {
            if (carrinho[j].idProduto == produtos[i].id) {
                console.log(j);
                lista+="<tr>"
                lista+="<td>"+produtos[i].nomeProduto+"</td>";
                lista+="<td>"+carrinho[j].quantidade+"</td>";
                lista+="<td>"+(produtos[i].preco*carrinho[j].quantidade)+"</td>";
                //lista+="<td> REMOVER onclick='removerProduto()'";  melhoria para adicinar ao carrinho com a possibilidade de comprar ou remover
                lista+="</tr>";
                //$("table tbody").append();
                console.log(lista);
                break;
            }
        }
    }
    document.getElementById('carrinho-tabela').innerHTML = lista;
}