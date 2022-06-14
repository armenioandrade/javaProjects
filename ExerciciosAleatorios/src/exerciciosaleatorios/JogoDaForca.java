package exerciciosaleatorios;

import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        JogoDaForcaClass jogo = new JogoDaForcaClass();
        
        jogo.setPalavraParaAdivinhar("armenio");
        jogo.procuraLetraNaPalavra('o');
        jogo.procuraLetraNaPalavra('a');
        jogo.procuraLetraNaPalavra('r');
        System.out.println(jogo.getPalavraDaForca());
   
    }
}
