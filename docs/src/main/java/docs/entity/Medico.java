package docs.entity;

import docs.type.Sexo;
import gate.annotation.Description;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.constraint.Maxlength;
import gate.constraint.Required;
import gate.type.ID;

@Icon("1000")
@Name("Médico")
public class Medico {

    @Required
    @Name("Nome")
    @Maxlength(64)
    @Description("Nome do médico")
    private String nome;
    @Required
    @Name("CPF")
    @Description("CPF do médico")
    private String cpf;
    @Required
    @Name("CRM")
    @Description("CRM do médico")
    private String crm;
    @Required
    @Name("Sexo")
    @Description("Sexo do médico")
    private Sexo sexo;
    @Required
    @Name("ID")
    private ID id;

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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}
