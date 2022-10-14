package com.dio.springboot.appcep;

import com.dio.springboot.appcep.app.ConversorJson;
import com.dio.springboot.appcep.app.ViaCepResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppcepApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppcepApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ConversorJson conversor) throws Exception {
        return args
                -> {
            String json = "{\"cep\": \"54430-350\", \"logradouro\": \"Av Anibal Ribeiro Varejao\", \"localidade\":\"Jaboatão dos Guararapes\"}";
            ViaCepResponse response = conversor.converter(json);
            System.out.println("Dados do cep: " + response);
        };
    }
}
