package entity;


public class Medico {


    private String nome;

    private String cpf;

    private String crm;

    private String sexo;

    private int id;

    public Medico(String nome, String cpf, String crm, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.sexo = sexo;
    }

    public Medico() {
    }
    
    public Medico(int id, String nome, String cpf, String crm, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.sexo = sexo;
        this.id = id;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Medico{" + "nome=" + nome + ", cpf=" + cpf + ", crm=" + crm + ", sexo=" + sexo + ", id=" + id + '}';
    }
    

}
