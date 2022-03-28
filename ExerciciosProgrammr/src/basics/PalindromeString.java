package basics;

import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        /*Faça um programa que leia uma string e verifique se ela é palindroma,
        por ex, "level" vai retornar "palavra palindroma" e "helloworld" vai retornar 
        palavra nao palindroma.
        
        
         */
        System.out.println("Digite uma palavra para verificar se é palindroma");
        Scanner scan = new Scanner(System.in);
        String nome = scan.next();

        //Alimentando array com cada letra da palavra
        String[] arrayNome = new String[nome.length()];
        int contadorAux = 0;
        for (int i = 1; i <= arrayNome.length; i++) {
            arrayNome[contadorAux] = nome.substring(contadorAux,i);
            contadorAux++;
        }
        
        
        //Array para armazenar palavra ao contrario
        String[] arrayAux = new String[arrayNome.length];
        int contadorAux2 = arrayAux.length;
        for (int i = 0; i < arrayAux.length; i++) {
            contadorAux2--;
            arrayAux[i] = arrayNome[contadorAux2];
            
        }
        
        //Comparando palavras
        for (int i = 0; i < arrayAux.length; i++) {
            if (arrayNome[i].equalsIgnoreCase(arrayAux[i])) {
                System.out.println("PALAVRA PALINDROMA");
                break;
            } else {
                System.out.println("PALAVRA NAO E PALINDROMA");
                break;
            }
            
        }
        
}
}