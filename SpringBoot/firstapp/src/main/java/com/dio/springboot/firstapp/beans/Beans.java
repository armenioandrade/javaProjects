
package com.dio.springboot.firstapp.beans;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Anotaacao Opcional. Recomendada para classes que terão anotacoes do tipo Bean.
public class Beans {
       @Bean
       public Scanner in(){
           return new Scanner(System.in);
       }
}
