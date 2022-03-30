
package basics;

import java.util.Scanner;

public class ReverseString {
        public static void main(String[] args) {
       /*1. Write a Java program to reverse a string without using the reverse method of Java's String class
            This exercise will teach you about how Java handles strings. 
            First, you should create a class with a main method that accepts a string and then returns a string 
            where the characters are in reverse order. But, you can't use the reverse method of the String class 
            because that’d be cheating.     
            */
        System.out.println("Digite uma palavra");
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
        //Imprimindo palavra ao contrario
            for (int i = 0; i < arrayAux.length; i++) {
                System.out.print(arrayAux[i]);
                
            }
            System.out.println("");
    }
}
