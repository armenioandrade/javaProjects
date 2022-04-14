package exerciciosdio;

import java.util.Scanner;

public class ExerciciosDIO {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int cont = 0;
        int soma = 0;
        boolean whiler = true;
        //complete o codigo

        while (whiler == true) {
            int n = leitor.nextInt();

            if (n > 0) {
                soma = soma + n;
                cont++;
            } else {
                whiler = false;
            }
            

        }
        
        float media = soma / cont;
        
        System.out.println(String.format("%.2f", media));
    }

}
