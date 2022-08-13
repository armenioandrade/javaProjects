package exerciciosedabit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ValidatePIN vp = new ValidatePIN();
        System.out.println("Digite um PIN para validação: ");
        vp.PINValidation(scan.nextLine());
        

    }

}
