package conversor;

import java.util.Scanner;

public class CPF {

    String numeroCPF;
    Scanner scan = new Scanner(System.in);

    void printCPF(String cpf) {
        System.out.println(cpf.substring(0, 3) + "."
                + cpf.substring(3, 6) + "."
                + cpf.substring(6, 9) + "-"
                + cpf.substring(9, 11));
    }

    String getCPF() {
        return numeroCPF;

    }

    void setCPF(String cpf) {
        this.numeroCPF = cpf;
    }

    void askCPF() {
        System.out.println("Digite o CPF: ");
        setCPF(scan.next());
    }

    void setCPFPadrao(String cpf) {
        this.numeroCPF = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    String parseCPF(String cpf) {
        numeroCPF = cpf.substring(0, 3) + "."
                + cpf.substring(3, 6) + "."
                + cpf.substring(6, 9) + "-"
                + cpf.substring(9, 11);
        return numeroCPF;
    }

}
