/*
 * Validacao de formularios
 */

function validar() {
    let nome = frmContato.nome.value;
    let fone = frmContato.fone.value;
    let email = frmContato.email.value;

    if (nome === "") {
        alert('Preencha o campo nome');
        frmContato.nome.focus();
        return false; //Retorna false e nao envia os dados pra camada superior
    } else if (fone === "") {
        alert('Preencha o campo fone');
        frmContato.fone.focus();
        return false;
    } else {
        document.forms["frmContato"].submit(); //envia os dados para camada superior
    }
}

function confirmarDelete(idcon) {

    let condicao = confirm('Confirma exclusão do registro?')
    if (condicao === true) {
        window.location.href = "delete?idcon=" + idcon
    } else {

    }


}