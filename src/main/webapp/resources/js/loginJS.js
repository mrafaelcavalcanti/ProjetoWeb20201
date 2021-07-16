function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function setTipoUsuario (tipo){
    var tipoUser = document.getElementById("tipoUsuarioCadastrar");
    tipoUser.value = tipo;
    if (tipo==0) {
        document.getElementById("produtor").classList.add("ativo");
        if (document.getElementById("consumidor").classList.contains("ativo")) {
            document.getElementById("consumidor").classList.remove("ativo");
            document.getElementById("tipo_usuario_setado").value = 1; 
        }
    } else {
        document.getElementById("consumidor").classList.add("ativo");
        if (document.getElementById("produtor").classList.contains("ativo")) {
            document.getElementById("produtor").classList.remove("ativo");
            document.getElementById("tipo_usuario_setado").value = 0;
        }
    }
}

function switchEntrarCadastrar (option) {
    if (option == 0) {
        document.getElementById("cadastrar").classList.add("inativo");
        document.getElementById("entrar-page").classList.remove("inativo");
        document.getElementById("entrar").classList.add("inativo");
        document.getElementById("cadastrese").classList.remove("inativo");
    } else {
        if (!document.getElementById("cadastrar").classList.contains("transicao")) {
            document.getElementById("cadastrar").classList.add("transicao")
        }
        document.getElementById("cadastrar").classList.remove("inativo");
        document.getElementById("entrar-page").classList.add("inativo");
        document.getElementById("entrar").classList.remove("inativo");
        document.getElementById("cadastrese").classList.add("inativo");
    }
}


function entrar() {
    document.getElementById("entrar-usuario-username").value = document.getElementById("emailLogin").value;
    document.getElementById("entrar-usuario-password").value = document.getElementById("senhaLogin").value;
    document.getElementById("entrar-usuario-entrar").click();
}


function doPostUsuario(url, idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep) {
    fetch(url, {
        method: 'POST',
        body:JSON.stringify({
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
                cidade: "cidade",
                bairro: bairro,
                rua: rua,
                numero: numero,
                complemento: complemento,
                cep: cep
            }
        }), 
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        }
    })
    .then(function(response){
        return response.json()
    })
    .then(function(data){
        alert("Usuario cadastrado com sucesso, realize o login")
    })
}

var postUsuario = function (idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep) {
    
    doPostUsuario('http://localhost:8080/api/usuarios/', idU, nome, email, senha, telefone, tipoUsuario, numeroCartao, chavePix, id, cidade, bairro, rua, numero, complemento, cep);

}

function cadastrar() {
    //document.getElementById("cadastrar-usuario-nome").value = document.getElementById("nomeUsuario").value;
    //document.getElementById("cadastrar-usuario-email").value = document.getElementById("email").value;
    //document.getElementById("cadastrar-usuario-senha").value = document.getElementById("senha").value;
    //document.getElementById("cadastrar-usuario-tipo_usuario").value = document.getElementById("tipo_usuario_setado").value;
    //document.getElementById("cadastrar-usuario-cadastrar").click();
    var nome = document.getElementById("nomeUsuario").value;
    var email = document.getElementById("email").value;
    var senha = document.getElementById("senha").value;
    var tipo_usuario = document.getElementById("tipoUsuarioCadastrar").value;
    postUsuario(100000000, nome, email, senha, tipo_usuario, null, null, null, 100000000, null, null, null, null, null, null );
    
}

window.onload = function () {
    document.getElementById('nomeUsuario').addEventListener('click', focar);
    document.getElementById('email').addEventListener('click', focar);
    document.getElementById('senha').addEventListener('click', focar);
    document.getElementById('emailLogin').addEventListener('click', focar);
    document.getElementById('senhaLogin').addEventListener('click', focar);
    async function focar() {
        if ( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
            await sleep(300);
            window.scroll(0, document.body.scrollHeight);
        }
    }
    
}

    //ainda falta o codigo para inserir o os dados no form

    
    