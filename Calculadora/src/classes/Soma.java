
package classes;


public class Soma {
    private Double valor1;
    private Double valor2;
    private Double resultado;
    
    public void efetuarSoma(Double a, Double b){
        valor1 = a;
        valor2 = b;
        resultado = a + b;
    }

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

    public Double getResultado() {
        return resultado;
    }
    
    
}
