/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projetoconcessionariaweb;

/**
 *
 * @author amaf
 */
public class ProjetoConcessionariaMain {

    public static void main(String[] args) {
        PessoaDAO pd = new PessoaDAO();
        Pessoa p = new Pessoa("gabriel", "000000", "gab@gmail.com", "999999");
        //pd.adicionarPessoa(p);
        //pd.atualizarPessoaByCpf(p);
        //p.setAtivo(0);
        //pd.desativarPessoaByCpf(p);
        //Pessoa p2 = new Pessoa();
        //p2.setCpf("07590244481");
        //pd.deletarPessoaByCpf(p2);
        System.out.println(pd.listarPessoas().toString());

    }
}
