$(document).ready(function () {
    $("#conteudo").load("mes.html");
    var liTab = $("nav.tabs>ul>li");
    liTab.on("click", function () {
        liTab.removeClass('is-active');
        $(this).toggleClass('is-active');

        $("#conteudo").html('<tr><td>01/01/2018</td><td>Primeiro/Segundo</td><td>Milton</td><td>Ciência da Computação</td><td>1 Semestre</td><td><a class="button is-link" title="Disabled button">Cancelar</a></td></tr>');
    });
});

function enviar(form) {
    var array_nao_indexado = $("form").serializeArray();
    var array_indexado = {};
    var url = 'rest/agendamentos';
    var metodo = 'POST';

    $.map(array_nao_indexado, function (n, i) {
        array_indexado[n['name']] = n['value'];
    });


    $.ajax({
        url: url,
        type: metodo,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(array_indexado),
        sucess: function (data) {
            console.log("Suuucesuuu...");
            console.log(JSON.stringify(array_indexado));
        },
        error: function () {
            console.log('Errooouuuuu');
        }
    });
}

function novoModal(el) {
    if (el.value == -1) {
        console.log("abrir modal " + el.getAttribute('data-target'));
    }
}

function alternar(id) {
    $("#" + id).toggleClass('is-active');
}
;