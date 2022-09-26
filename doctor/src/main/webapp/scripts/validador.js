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
    let url = window.location.href
    let arrayUrl = url.split('/')
    let path = arrayUrl[arrayUrl.length - 1]
    console.log(arrayUrl)
    console.log(path)
    let condicao = confirm('Confirma exclusão do registro?')
    if (condicao === true) {
        if(path === 'PacientView'){
            window.location.href = 'PacientDelete?id='+id
        } else if(path === 'DoctorView')
        window.location.href = 'DoctorDelete?id='+id
    } 


}