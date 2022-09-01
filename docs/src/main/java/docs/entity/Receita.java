package docs.entity;

import gate.annotation.Icon;
import gate.annotation.Name;
import gate.type.ID;

@Icon("1001")
@Name("Receita")
public class Receita {
    private ID id;
    @Name("Medico")
    Medico medico;
    @Name("Paciente")
    Paciente paciente;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
