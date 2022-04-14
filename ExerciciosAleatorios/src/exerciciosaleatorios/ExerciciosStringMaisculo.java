package exerciciosaleatorios;

import java.util.Scanner;

public class ExerciciosStringMaisculo {

    public static void main(String[] args) {
        /*  Faça um programa que receba uma String e imprima com primeiro caracter maiúsculo
         */
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        String[] arraySplit = entrada.split(" ");
        
        /*Alimentando array substituindo primeira letra de cada posicao do array por ela mesma maisculo
          Removendo as palavras "De" "Da" "Do" com D maiúsculo      
        */
        for (int i = 0; i < arraySplit.length; i++) {
            arraySplit[i] = arraySplit[i].substring(0, 1).toUpperCase() + arraySplit[i].substring(1, arraySplit[i].length());
            if(arraySplit[i].equalsIgnoreCase("de")){
                arraySplit[i] = "de";
            }else if(arraySplit[i].equalsIgnoreCase("da")){
                arraySplit[i] = "da";
            }else if(arraySplit[i].equalsIgnoreCase("do")){
                arraySplit[i] = "do";
            }
            
        }

        //Imprimindo na tela o nome completo
        System.out.print("Nome completo: ");
        for (String i : arraySplit) {
            System.out.print(i+" ");
        }
        System.out.println();
        
        //Criando login no padrão primeiro.ultimonome       
        String login = arraySplit[0].toLowerCase().concat(".") + arraySplit[arraySplit.length-1].toLowerCase();       
        System.out.print("Login: "+login+"\n");       
    }
}
