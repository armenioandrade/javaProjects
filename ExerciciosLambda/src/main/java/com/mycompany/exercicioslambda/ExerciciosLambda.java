/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.exercicioslambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.smartcardio.ATR;

/**
 *
 * @author amaf
 */
public class ExerciciosLambda {

    public static void main(String[] args) {

        int ano = 2022;
        Revisao rev = new Revisao() {

            @Override
            public void primeiraRevisao(int ano) {
                if (ano == 2022) {
                    System.out.println("revisao gratuita! (sem lambda)");
                }
            }
        };
        rev.primeiraRevisao(ano);

        int ano1 = 2022;
        Revisao rev2 = (int anoParametro) -> {
            if (ano1 == 2022) {
                System.out.println("revisao gratuita! (com lambda)");
            }

        };
        rev2.primeiraRevisao(ano1);

        List<Integer> numeros = new ArrayList();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        //Imprima numeros maiores que 2
        numeros.stream().filter(i -> i > 2).forEach(j -> System.out.println(j));
        
                 
        //Capitais do Mundo
        List<String> cidadesDoMundo = new ArrayList<>();
        cidadesDoMundo.add("Brasil, Sao Paulo");
        cidadesDoMundo.add("Brasil, Recife");
        cidadesDoMundo.add("Brasil, Salvador");
        cidadesDoMundo.add("EUA, New York");
        cidadesDoMundo.add("EUA, Washington");
        cidadesDoMundo.add("China, Pequim");
        cidadesDoMundo.add("China, Wong Ju");
        cidadesDoMundo.add("China, Xao Ion");
        
        
        //Imprimindo cidades do Brasil apenas
        cidadesDoMundo.stream()
                .filter(cidade -> cidade.startsWith("Brasil"))
                .forEach(c -> System.out.println(c.substring(c.indexOf(" "),c.length()).strip()));
        
        //Imprimindo cidades do EUA
        cidadesDoMundo.stream().filter(cidade -> cidade.startsWith("EUA")).forEach(c -> System.out.println(c));
        
        //Colete cidades da china para outra Lista
        List<String> china = new ArrayList<>();
        china = cidadesDoMundo.stream().filter(cidade -> cidade.startsWith("China")).collect(Collectors.toList());
        System.out.println(china);

        
        
    }//Chave metodo main

    
    interface Revisao {

        public void primeiraRevisao(int ano);

    }

}
