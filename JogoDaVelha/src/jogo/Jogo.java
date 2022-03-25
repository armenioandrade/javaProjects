package jogo;

import java.util.Scanner;

public class Jogo {

    private String[] tabuleiro = new String[9];
    public boolean vitoria = false;
    public boolean continua = true;
    Scanner scan = new Scanner(System.in);

    public String[] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    void organizarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[i] = "P" + i;

        }
    }

    void printTabuleiro() {
        System.out.println("\n");
        for (int i = 0; i < getTabuleiro().length; i++) {
            System.out.print(getTabuleiro()[i] + " ");
            if (i == 2 || i == 5) {
                System.out.println(" ");
            } else if (i == 8) {
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    void jogadaJogador1(String posicao) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (posicao.equalsIgnoreCase(tabuleiro[i])) {
                tabuleiro[i] = "X";
            }
        }

    }

    void jogadaJogador2(String posicao) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (posicao.equalsIgnoreCase(tabuleiro[i])) {
                tabuleiro[i] = "O";
            }
        }

    }

    boolean confereTabuleiro(String marcador) {
        if (tabuleiro[0].equalsIgnoreCase(marcador) && tabuleiro[1].equalsIgnoreCase(marcador) && tabuleiro[2].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[3].equalsIgnoreCase(marcador) && tabuleiro[4].equalsIgnoreCase(marcador) && tabuleiro[5].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[6].equalsIgnoreCase(marcador) && tabuleiro[7].equalsIgnoreCase(marcador) && tabuleiro[8].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[0].equalsIgnoreCase(marcador) && tabuleiro[3].equalsIgnoreCase(marcador) && tabuleiro[6].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[1].equalsIgnoreCase(marcador) && tabuleiro[4].equalsIgnoreCase(marcador) && tabuleiro[7].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[2].equalsIgnoreCase(marcador) && tabuleiro[5].equalsIgnoreCase(marcador) && tabuleiro[8].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[0].equalsIgnoreCase(marcador) && tabuleiro[4].equalsIgnoreCase(marcador) && tabuleiro[8].equalsIgnoreCase(marcador)) {
            vitoria = true;
        } else if (tabuleiro[6].equalsIgnoreCase(marcador) && tabuleiro[4].equalsIgnoreCase(marcador) && tabuleiro[2].equalsIgnoreCase(marcador)) {
            vitoria = true;
        }
        return vitoria;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public void iniciarPartida() {
        System.out.println("JOGO DA VELHA");
        organizarTabuleiro();
        while (continua) {
            printTabuleiro();
            System.out.print("Turno do Jogador 1: ");
            jogadaJogador1(scan.next());
            if (confereTabuleiro("X") == true) {
                printTabuleiro();
                System.out.println("FIM DO JOGO!");
                System.out.println("Temos um vencedor, Jogador 1");
                break;
            }
            System.out.print("Turno do Jogador 2: ");
            jogadaJogador2(scan.next());
            if (confereTabuleiro("O") == true) {
                printTabuleiro();
                System.out.println("FIM DO JOGO!");
                System.out.println("Temos um vencedor, Jogador 2");
                break;
            }
        }
    }
}
