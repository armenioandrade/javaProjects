package basics;

import java.util.Scanner;

public class BinaryNumberCheck {

    public static void main(String[] args) {
        /*
        A binary number is written as combination of 1's and 0's.
        Binary number 100 indicates 4.

        Write a program which accepts a number and prints whether it is binary or not.

        For Ex:

        1) if user inputs 1040400
        then it should print "Not Binary".

        2) if user inputs 1000100
        then it should print "Binary".  
        
        
         */
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um numero");
        String numero = scan.next();
        if(numero.matches("[0-1][0-1][0-1][0-1]")){
            System.out.println("NUMERO BINARIO");
        }else{
            System.out.println("NUMERO NAO BINARIO");
        }
    }

}
