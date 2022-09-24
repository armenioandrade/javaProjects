/*
 * Validacao de formularios
 */

function validar() {
    let nome = formDefault.nome.value;
    let cpf = formDefault.fone.value;
    let crm = formDefault.email.value;

    if (nome === "") {
        alert('Preencha o campo nome');
        formDefault.nome.focus();
        return false; //Retorna false e nao envia os dados pra camada superior
    } else if (fone === "") {
        alert('Preencha o campo fone');
        formDefault.fone.focus();
        return false;
    } else {
        document.forms["formDefault"].submit(); //envia os dados para camada superior
    }
}

function confirmarDelete(id) {

    let condicao = confirm('Confirma exclusão do registro?')
    if (condicao === true) {
        window.location.href = "delete?id=" + id
    } else {

    }


}