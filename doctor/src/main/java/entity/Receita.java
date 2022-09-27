package entity;

import java.time.LocalDate;

public class Receita {

    private int id;

    private Medico medico;

    private Paciente paciente;

    private String descricao;
    
    private LocalDate dataRegistro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        if (medico == null) {
            medico = new Medico();
        }
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        if(paciente == null){
            paciente = new Paciente();
        }
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Receita(int id, Medico medico, Paciente paciente, String descricao, LocalDate dataRegistro) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }
    
    public Receita(int id, String medico, String paciente, String descricao, LocalDate dataRegistro) {
        if(this.medico == null){
            this.medico = new Medico();
        }
        if(this.paciente == null){
            this.paciente = new Paciente();
        }
        this.id = id;
        this.medico.setNome(medico);
        this.paciente.setNome(paciente);
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }

    public Receita(Medico medico, Paciente paciente, String descricao, LocalDate dataRegistro) {
        this.medico = medico;
        this.paciente = paciente;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }
    
    
    
    
    public Receita() {
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", medico=" + medico.getNome() + ", paciente=" + paciente.getNome() + ", descricao=" + descricao + ", dataRegistro=" + dataRegistro + '}';
    }
    
    
    
    
}
