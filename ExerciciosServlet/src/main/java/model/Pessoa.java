
package model;


public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int ativo = 1;

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Pessoa(){
        
    }
    
    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "{" +"nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", ativo=" + ativo + '}';
    }
    
    
    
}
