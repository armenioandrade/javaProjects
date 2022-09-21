package entity;

import java.time.LocalDate;

public class Paciente {

    private int id;

    private String sexo;

    private String cpf;

    private String nome;

    private LocalDate dataNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getString() {
        return sexo;
    }

    public void setString(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", sexo=" + sexo + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
}
