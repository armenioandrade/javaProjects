/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author amaf
 */
public class Subracao {
        private Double valor1;
    private Double valor2;
    private Double resultado;
    
    public void efetuarSubtracao(Double a, Double b){
        valor1 = a;
        valor2 = b;
        resultado = a - b;
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

