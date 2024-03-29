package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_agenda?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "NS@DQX1s";

    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("e");
            return null;
        }
        return con;
    }

    //CRUD - INSERT
    //Inserir Contatos
    public void inserirContato(JavaBeans contato) {
        String create
                = "insert into contatos (nome, fone, email) values (?,?,?)";
        try {
            Connection con = conectar();
            //Preparar a query para execucao no BD
            PreparedStatement pst = con.prepareStatement(create);
            //Substituir os parametros da query (?) pelo conteudo do objeto contato
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getFone());
            pst.setString(3, contato.getEmail());
            //Executar a query
            pst.executeUpdate();
            //Encerre para nao causar problemas de performance e seguranca
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //CRUD - READ
    //Listar Contatos 

    public ArrayList<JavaBeans> listarContatos() {
        //Criando objeto para acessar a classe JavaBeans
        ArrayList<JavaBeans> contatos = new ArrayList<>();
        String read = "select * from contatos order by nome";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            // Laço abaixo será executado enquanto houver contatos
            while (rs.next()) {
                //Variaveis de apoio que recebem os dados do banco
                String idcon = rs.getString(1);
                String nome = rs.getString(2);
                String fone = rs.getString(3);
                String email = rs.getString(4);
                //Populando o ArrayList
                contatos.add(new JavaBeans(idcon, nome, fone, email));

            }
            con.close();
            return contatos;
        } catch (Exception e) {
        }
        return null;
    }

    //CRUD - UPDATE
    //Selecionar contato
    public void selecionarContato(JavaBeans contato) {
        String read = "select * from contatos where idcon=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setString(1, contato.getIdcon());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //setar variaveis javabeans
                contato.setIdcon(rs.getString(1));
                contato.setNome(rs.getString(2));
                contato.setFone(rs.getString(3));
                contato.setEmail(rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //CRUD - UPDATE PT2
    //Editar o contato
    public void alterarContato(JavaBeans contato) {
        String create = "update contatos set nome=?, fone=?, email=? where idcon=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getFone());
            pst.setString(3, contato.getEmail());
            pst.setString(4, contato.getIdcon());
            pst.execute();
            con.close();
        } catch (Exception e) {
        }
    }

    public void deletarContato(JavaBeans contato) {
        String delete = "delete from contatos where idcon=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, contato.getIdcon());
            pst.execute();
            con.close();
        } catch (Exception e) {
        }
    }
}
