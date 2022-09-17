
package entity;

import java.time.LocalDateTime;



public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String sexo;
    private String telefone;
    private LocalDateTime dataNascimento;
    private boolean status;
    private int id;

    public Cliente(String nome, String cpf, String email, String sexo, String telefone, LocalDateTime dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.status = true;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append(", ID=").append(id);
        sb.append(". nome=").append(nome);
        sb.append(", cpf=").append(cpf);
        sb.append(", email=").append(email);
        sb.append(", sexo=").append(sexo);
        sb.append(", telefone=").append(telefone);
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
