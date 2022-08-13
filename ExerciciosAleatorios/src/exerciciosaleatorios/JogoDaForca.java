package exerciciosaleatorios;

import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        JogoDaForcaClass jogo = new JogoDaForcaClass();
        System.out.println("Digite a palavra da Forca");
        jogo.setPalavraParaAdivinhar(scan.nextLine());
        while(jogo.statusDoJogo() == false){
        System.out.println("Digite a letra a ser procurada");
        jogo.procuraLetraNaPalavra(scan.next().charAt(0));
        jogo.imprimePalavraDaForca();
        jogo.statusDoJogo();
        }
        
        
    }
}
