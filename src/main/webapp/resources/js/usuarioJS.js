function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function fecharCadatroProduto() {
    document.getElementById("fecharCadatroProduto").classList.add("transicao");
    document.getElementById("fecharCadatroProduto").classList.remove("ativa");
    await sleep(300);
    document.getElementById("fecharCadatroProduto").classList.add("inativa");
}

function abrirCadastrarProduto() {
    document.getElementById("fecharCadatroProduto").classList.add("ativa");
    document.getElementById("fecharCadatroProduto").classList.remove("inativa");
}

window.onload = function () {
    var id = document.getElementById("usuario-logado").textContent;
    getUsuario(id);
}


function atualizarDadosUsuario() {
    var idUsuario = parseInt(document.getElementById("usuario-logado").textContent);
    var nome = document.getElementById("nome").value;
    var email = document.getElementById("email").value;
    var telefone = document.getElementById("telefone").value;
    if (document.getElementById("tipo-usuario").value == "CONSUMIDOR") {
        var tipoUsuario = 1;
    } else {
        var tipoUsuario = 0;
    }
    var senha = document.getElementById("senha").value;
    var idEndereco = document.getElementById("id-endereco").value;
    var cidade = document.getElementById("cidade-endereco").value;
    var bairro = document.getElementById("bairro-endereco").value;
    var rua = document.getElementById("rua-endereco").value;
    var numero = document.getElementById("numero-endereco").value;
    var complemento = document.getElementById("complemento-endereco").value;
    var cep = document.getElementById("cep-endereco").value;

    putUsuario(idUsuario, nome, email, senha, telefone, tipoUsuario, null, null, idEndereco, cidade, bairro, rua, numero, complemento, cep);
}

function cadastrarProduto() {
    var id_usuario = parseInt(document.getElementById("usuario-logado").textContent);
    var nome = document.getElementById("nome-produto").value;
    var categoria = parseInt(document.getElementById("categoria-produto").value);
    var peso = parseInt(document.getElementById("peso-produto").value);
    var preco = document.getElementById("preco-produto").value;
    var quantidade = parseInt(document.getElementById("quantidade-produto").value);
    postProduto(100000000, nome, categoria, peso, preco, quantidade, id_usuario);
}




// ------ REQUISIÇÔES PARA A API ----------

const doGet = (url) => {
    const promisseCallback = (resolve, reject) => {
        fetch(url)
            .then(function (response) {
                if (!response.ok) throw new Error('Erro ao obter usuario, status' + response.status);
                return response.json();

            }).then(function (data) {
                resolve = data;
                document.getElementById("nome").value = data.nome;
                document.getElementById("email").value = data.email;
                document.getElementById("telefone").value = data.telefone;
                if (data.tipoUsuario == 1) {
                    document.getElementById("tipo-usuario").value = "CONSUMIDOR";
                } else {
                    document.getElementById("tipo-usuario").value = "PRODUTOR";
                }
                document.getElementById("senha").value = data.senha;
                document.getElementById("id-endereco").value = data.endereco.id;
                document.getElementById("cidade-endereco").value = data.endereco.cidade;
                document.getElementById("bairro-endereco").value = data.endereco.bairro;
                document.getElementById("rua-endereco").value = data.endereco.rua;
                document.getElementById("numero-endereco").value = data.endereco.numero;
                document.getElementById("complemento-endereco").value = data.endereco.complemento;
                document.getElementById("cep-endereco").value = data.endereco.cep;
            })
            .catch(reject);
    }
    return new Promise(promisseCallback);
}

function doPostProduto(url, id, nome, categoria, peso, preco, quantidade, id_usuario) {
    fetch(url, {
        method: 'POST',
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
            return response.json();
        })
        .then(function (data) {
            if(data.lengt) {
                console.log(data);
                alert("Produto cadastrado com sucesso");
            }
        })
}

function doPutUsuario(url, idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep) {
    fetch(url, {
        method: 'PUT',
        body: JSON.stringify({
            id: idU,
            nome: nome,
            email: email,
            senha: senha,
            telefone: telefone,
            tipoUsuario: tipoUsuario,
            numeroCartao: numeroCartao,
            chavePix: chavePix,
            imagemPerfil: null,
            endereco: {
                id: id,
                cidade: cidade,
                bairro: bairro,
                rua: rua,
                numero: numero,
                complemento: complemento,
                cep: cep
            }
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
                alert("Usuario atualizado com sucesso");
            }
        })
}

var getUsuario = function (id) {

    doGet('http://localhost:8080/api/usuarios/get/' + id).then(console.log);
}

var getProdutos = function (id) {
    doGet('http://localhost:8080/api/produtos/' + id + '/all');
}

var putUsuario = function (idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep) {
    doPutUsuario('http://localhost:8080/api/usuarios/', idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep);
}

var postProduto = function (id, nome, categoria, peso, preco, quantidade, id_usuario) {
    doPostProduto("http://localhost:8080/api/produtos/", id, nome, categoria, peso, preco, quantidade, id_usuario);
}