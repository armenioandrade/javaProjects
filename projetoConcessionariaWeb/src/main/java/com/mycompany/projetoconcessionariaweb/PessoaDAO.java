package com.mycompany.projetoconcessionariaweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    Connection conn = null;

    public void adicionarPessoa(Pessoa p) {
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("insert into pessoa (nome,cpf,email,telefone)values(?,?,?,?)");

            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getCpf());
            pstm.setString(3, p.getEmail());
            pstm.setString(4, p.getTelefone());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db" + ex.getMessage());
        }

    }

    public void atualizarPessoaByCpf(Pessoa p) {
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("update pessoa set nome=?,email=?,telefone=? where cpf=?");
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getEmail());
            pstm.setString(3, p.getTelefone());
            pstm.setString(4, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db" + ex.getMessage());
        }

    }

    public void desativarPessoaByCpf(Pessoa p) {
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("update pessoa set ativo=? where cpf=?");
            pstm.setInt(1, p.getAtivo());
            pstm.setString(2, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db" + ex.getMessage());
        }
    }

    public void deletarPessoaByCpf(Pessoa p) {
        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("delete from pessoa where cpf=?");
            pstm.setString(1, p.getCpf());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db" + ex.getMessage());
        }
    }

    public Pessoa selecionarPessoaByCpf(String cpf) {
        Pessoa p = null;

        try {
            PreparedStatement pstm = ConexaoDB.Conectar().prepareStatement("select * from pessoa where cpf=?");
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));

            }
            rs.close();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db" + ex.getMessage());
        }
        return p;

    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> list = new ArrayList<>();

        try {

            PreparedStatement ps = ConexaoDB.Conectar().prepareStatement("select * from pessoa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setCpf(rs.getString("cpf"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
