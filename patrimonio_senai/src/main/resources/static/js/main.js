document.addEventListener("DOMContentLoaded", () => {
    var solicitacoes = document.querySelector(".solicitacoes");
    var fundo = document.querySelector(".fundo");

    window.menuSolicToggle = function () {
        if (solicitacoes.style.display === "flex") {
            solicitacoes.style.display = "none";
            fundo.style.display = "block";
        } else {
            solicitacoes.style.display = "flex";
            fundo.style.display = "block";
        }
        console.log("Display:", solicitacoes.style.display);
    };

    window.menuSolicClose = function () {
        if (solicitacoes.style.display === "flex") {
            solicitacoes.style.display = "none";
            fundo.style.display = "none";
        } else {
            solicitacoes.style.display = "flex";
            fundo.style.display = "block";
        }
    }
});

document.addEventListener("DOMContentLoaded", () => {
    var addNovo = document.querySelector(".adicionar button");
    var acoesVisivel = document.querySelector(".acoes-visivel");

    window.maisAcoes = function() {
        if (addNovo.style.display === "block") {
            acoesVisivel.style.display = "flex";
            addNovo.style.display = "none";
        }else{
            acoesVisivel.style.display = "none";
            addNovo.style.display = "block";
        }
    }
});