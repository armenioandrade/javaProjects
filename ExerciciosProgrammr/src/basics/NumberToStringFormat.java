package basics;

import java.util.Scanner;

public class NumberToStringFormat {
	public static String ones[]=
            {"one","two","three","four","five","six"," seven", 
            "eight","nine","ten","eleven","twelve","thirteen","forteen","fifteen","sixteen",
            "seventeen","eighteen","ninteen"};      
        
        public static String tens[]=
        {"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"};     
        
    public static void main(String[] args) {
        /*Complete the following program which takes input as a number and converts it into string format.Initially arrays of string are given just use it for your logic.
        Scenario will be:
        Enter the number:
        54
        Entered number is:
        fifty four
        
        *
        */
        int aux;
        String apoio;
        Scanner scan = new Scanner(System.in);
        int numeroDeEntrada;
        System.out.println("Digite um número");
        numeroDeEntrada = scan.nextInt();
        
        if (numeroDeEntrada <= 19){
            for (int i = 0; i <= ones.length; i++) {
                if(numeroDeEntrada == i){
                    System.out.println("Numero por extenso: "+ones[i-1]);
                }
                
            }
 
        }else if(numeroDeEntrada >= 20 && numeroDeEntrada <= 29){
            apoio = tens[0];
            aux = numeroDeEntrada - 20;
            for (int i = 0; i < ones.length; i++) {
                if (aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
            
        }else if(numeroDeEntrada >= 30 && numeroDeEntrada <= 39){
            apoio = tens[1];
            aux = numeroDeEntrada - 30;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }else if(numeroDeEntrada >= 40 && numeroDeEntrada <= 49){
            apoio = tens[2];
            aux = numeroDeEntrada - 40;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }else if(numeroDeEntrada >= 50 && numeroDeEntrada <= 59){
            apoio = tens[3];
            aux = numeroDeEntrada - 50;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }else if(numeroDeEntrada >= 60 && numeroDeEntrada <= 69){
            apoio = tens[4];
            aux = numeroDeEntrada - 60;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }
        else if(numeroDeEntrada >= 70 && numeroDeEntrada <= 79){
            apoio = tens[5];
            aux = numeroDeEntrada - 70;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }
        else if(numeroDeEntrada >= 80 && numeroDeEntrada <= 89){
            apoio = tens[6];
            aux = numeroDeEntrada - 80;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }
        else if(numeroDeEntrada >= 90 && numeroDeEntrada <= 99){
            apoio = tens[7];
            aux = numeroDeEntrada - 90;
            for (int i = 0; i < ones.length; i++) {
                if(aux == i){
                    System.out.println("Numero por extenso: "+apoio+" "+ones[aux-1]);
                }
                
            }
        }
        
        
    }
}
