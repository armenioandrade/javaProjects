/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.PessoaDAO;

/**
 *
 * @author amaf
 */
public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        PessoaDAO pd = new PessoaDAO();
        p.setNome("update");
        p.setCpf("321");
        
        pd.atualizarPessoaByCpf(p);
        
    }
}
