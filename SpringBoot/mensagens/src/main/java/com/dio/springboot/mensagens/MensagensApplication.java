package com.dio.springboot.mensagens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MensagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensagensApplication.class, args);
	}
@Bean
public CommandLineRunner run(SistemaMensagem sistema) throws Exception{
    return args -> {
        sistema.enviarConfirmacaoCadastro();
        sistema.enviarMensagemBoasVindas();
    };
}
}
