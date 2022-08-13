
package com.mycompany.projetoconcessionaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PessoaDAO {

    Connection conn = null;
    
    public void adicionarPessoa(Pessoa p){
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("insert into pessoa (nome,cpf,email,telefone)values(?,?,?,?)");
            
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getCpf());
            pstm.setString(3, p.getEmail());
            pstm.setString(4, p.getTelefone());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db"+ex.getMessage());
        }
        
    }
    
    public void atualizarPessoaByCpf(Pessoa p){
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("update pessoa set nome=?,email=?,telefone=? where cpf=?");
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getEmail());
            pstm.setString(3, p.getTelefone());
            pstm.setString(4, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db"+ex.getMessage());
        }
        
    }
    
    public void desativarPessoaByCpf(Pessoa p){
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("update pessoa set ativo=? where cpf=?");
            pstm.setInt(1, p.getAtivo());
            pstm.setString(2, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db"+ex.getMessage());
        }
    }
    
    public void deletarPessoaByCpf(Pessoa p){
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("delete from pessoa where cpf=?");
            pstm.setString(1, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db"+ex.getMessage());
        }
    }
    
    
}
