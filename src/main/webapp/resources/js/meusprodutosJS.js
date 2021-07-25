var produtos = "";
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
        carregarProdutos(id);
        montarTabela();
}

//meu-carrinho

var carregarProdutos = function(id) {
    var url = "http://localhost:8080/api/produtos/getByUserProducts/"+id;
    fetch(url)
        .then(function (response) {
            if (!response.ok) throw new Error('Erro ao pesquisar produtos, status' + response.status);
            return response.json();
        }).then(function (data) {
            if(data.length==0) {
                alert("Nenhum produto encontrado");
            }
            produtos = data;
            console.log(produtos);
        })
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function montarTabela() {
    await sleep(300);
    var lista = "";
    for (var j = 0; j<produtos.length; j++) {
        console.log(j);
        lista+="<tr>"
        lista+="<td>"+produtos[j].categoria+"</td>";
        lista+="<td>"+produtos[j].nomeProduto+"</td>";
        lista+="<td>"+produtos[j].peso+"</td>"
        lista+="<td>"+produtos[j].preco+"</td>";
        lista+="<td>"+produtos[j].quantidade+"</td>";
        lista+="</tr>";
        console.log(lista);
    }
    document.getElementById('produtos-tabela').innerHTML = lista;
}