package banco;

public class Banco {

    private Double saque;
    private Double deposito;
    private int agencia;
    private int conta;
    private Double saldo;
    private Cliente[] bancoDeClientes;
    private String NomeDoBanco;

    public String getNomeDoBanco() {
        return NomeDoBanco;
    }

    public void setNomeDoBanco(String NomeDoBanco) {
        this.NomeDoBanco = NomeDoBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void sacar(Double saque) {
        this.setSaldo((Double) (this.getSaldo() - saque));
    }

    public void depositar(Double deposito) {
        this.setSaldo((Double) (this.getSaldo() + deposito));
    }

    public void listarTodosClientes() {
    }

    public void listarUmCliente(int numeroagencia, int numeroconta) {

    }
    /*
    public void setSizeBancoDeClientes(int t) {
        bancoDeClientes = new Cliente[t];
    }

    public int getSizeBancoDeClientes() {
        return bancoDeClientes.length;
    }
    public void addCliente(Cliente c){
        for (int i = 0; i < bancoDeClientes.length; i++) {
            bancoDeClientes[i] = c;
            
        }
    }
     */

}
