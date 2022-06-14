package exerciciosedabit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ValidatePIN vp = new ValidatePIN();
        System.out.println(vp.PINValidation(""));
        System.out.println(vp.PINValidation("3990"));
        

    }

}
