package com.dio.springboot.propertiesvalue;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Mensagem implements CommandLineRunner{

    @Value("${nome}") //Pode-se passar um valor por parametro usando @Value("${nome:Teste}") 
    private String nome;
    @Value("${telefones}")
    private List<Long> telefones;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Long> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "nome=" + nome + ", telefones=" + telefones + '}';
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem{" + "nome=" + nome + ", telefones=" + telefones + '}');
        System.out.println("Seu cadastro foi aprovado");
    }

}
