package exerciciosaleatorios;

import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        JogoDaForcaClass jogo = new JogoDaForcaClass();

        System.out.println("Entre com a palavra");
        String entrada = scan.nextLine();
        jogo.setPalavra(entrada);
        
        jogo.quadroNovo();
       // jogo.quadroAtual();
        
        jogo.procuraLetraNaPalavra("a", entrada);
        jogo.procuraLetraNaPalavra("b", entrada);
        jogo.imprimirPalavra();

    }
}
