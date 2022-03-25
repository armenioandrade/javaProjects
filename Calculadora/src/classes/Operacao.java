package classes;

public class Operacao {

    private String operacao;
    private Double resultado;
    private Double valor1;
    private Double valor2;

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }


    public Double getResultadoSoma() {
        return this.valor1 + this.valor2;
    }

    public Double getResultadoSub() {
        return this.valor1 - this.valor2;
    }

    public Double getResultadoMulti() {
        return this.valor1 * this.valor2;
    }

    public Double getResultadoDiv() {
        return this.valor1 / this.valor2;
    }
}
