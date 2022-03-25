package banco;

public class Cliente {

    private String nome;
    private Banco conta;
    private String cpf;

    public Cliente(String nomeCliente, String CPFCliente, String nomeDoBanco, int agencia, int numeroDaconta){
       this.nome = nomeCliente;
       this.cpf = CPFCliente;
       conta = new Banco();
       conta.setNomeDoBanco(nomeDoBanco);
       conta.setAgencia(agencia);
       conta.setConta(numeroDaconta);
       conta.setSaldo(0.0);
    
    }
    
    public Banco getConta() {
        return conta;
    }

    public void setConta(Banco conta) {
        this.conta = conta;
    }    
   
    
    public String getNome() {
        if (nome == null){
            return null;
        }
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
    }
