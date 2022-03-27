package exerciciomoto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExercicioMoto moto = new ExercicioMoto();
        Scanner scan = new Scanner(System.in);

        moto.setLigada(true);

        while (moto.getLigada() == true) {
            System.out.println("PROGRAMA MOTO\n 1.Ligar Moto\n 2.Desligar Moto\n 3.Acelerar\n 4.Frear\n 5.Saber Marcha\n 6.Obter velocidade\n 7.Status Geral");
            int opc = scan.nextInt();
            switch (opc) {
                case 1:
                    moto.setLigada(true);
                    break;
                case 2:
                    moto.setLigada(false);
                    break;
                case 3:
                    moto.acelerar();
                    break;
                case 4:
                    moto.frear();
                    break;
                case 5:
                    System.out.println(moto.getMarcha()+"* MARCHA");
                    break;
                case 6:
                    System.out.println(moto.getVelocidade()+"KM/h");
                    break;
                case 7:
                    System.out.println("A moto está "+moto.getLigada()+" a uma velocidade de: "+moto.getVelocidade()+"KM/h"+" na "+moto.getMarcha()+"* MARCHA");
                    moto.setLigada(false);
                    break;
            }
        }

    }
}
