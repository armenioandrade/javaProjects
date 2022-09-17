package dao;

import entity.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDao implements Dao {

    Connection conn = null;
    private static final String AUTHENTICATE = "SELECT * FROM cliente WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM cliente WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE cliente";
    private static final String FIND_BY_ID = "SELECT * FROM cliente WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM cliente ORDER BY id";
    private static final String INSERT = "INSERT INTO cliente (nome, cpf, email, sexo,telefone,dataNascimento,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE cliente SET nome=?, cpf=?, email=?, sexo=?, telefone=?, dataNascimento=?, status=? WHERE id=?";

    @Override
    public boolean authenticate(String eMail, String password) throws SQLException {
        return false;
    }

    @Override
    public void create(Cliente cliente) throws SQLException {
        try {

            PreparedStatement ps = getConnection().prepareStatement(INSERT);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getDataNascimento().toString());
            ps.setBoolean(7, true);

            ps.executeUpdate();
            ps.close();

            System.out.println("Cliente with following details was saved in DB: " + cliente.toString());

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Cliente cliente) throws SQLException {
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public void truncateTable() throws SQLException {
    }

    @Override
    public Cliente getDetailsById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        return null;
    }

    public Connection getConnection() {

        String dbURL = "jdbc:mysql://localhost:3306/concessionaria";
        String dbCliente = "root";
        String dbPassword = "NS@DQX1s";

        try {
            if (conn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL, dbCliente, dbPassword);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return conn;

    }

}
