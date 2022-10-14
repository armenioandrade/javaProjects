
package com.dio.springboot.firstapp.calculadora;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Anotacao padrao para identificar classe como componente do spring e ser lida pelo main do spring.
public class Menu implements CommandLineRunner { //Esse metodo serve para executar algo assim que a aplicacao subir.
    
    @Autowired  // injecao de dependencias
    private Calculadora Calculadora;
   @Autowired
   private Scanner in;
    
    @Override
    public void run(String... args) throws Exception {  //metodo do CommandLineRunner
        System.out.println("Entre com valor 1: ");
        int val1 = in.nextInt();
        System.out.println("Entre com valor 2: ");
        int val2 = in.nextInt();
        System.out.println("a soma é: " + Calculadora.somar(val1, val2));
    }
    
}
