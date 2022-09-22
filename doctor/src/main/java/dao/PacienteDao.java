package dao;

import entity.Medico;
import entity.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

public class PacienteDao implements Dao {

    Connection conn = null;
    private static final String AUTHENTICATE = "SELECT * FROM paciente WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM paciente WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE paciente";
    private static final String FIND_BY_ID = "SELECT * FROM paciente WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM paciente ORDER BY id";
    private static final String INSERT = "INSERT INTO Paciente (cpf,dataNascimento,sexo,nome) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE paciente SET nome=?, cpf=?, dataNascimento=?, sexo=? WHERE id=?";
    Paciente paciente = new Paciente();

    @Override
    public boolean authenticate(String eMail, String password) throws SQLException {
        
        return false;
    }
    
    
    public void create(Paciente paciente) throws SQLException {

        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(INSERT);

            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getDataNascimento().toString());    
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getNome());
            ps.executeUpdate();
            ps.close();

            System.out.println("Paciente with following details was saved in DB: " + paciente.toString());

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE);

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setDate(3, (Date) Date.from(paciente.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));    
            ps.setString(4, paciente.getSexo());
            ps.executeUpdate();
            ps.close();

            System.out.println("Paciente with id " + paciente.getId() + " was updated in DB with following details: " + obj.toString());

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(DELETE);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Paciente with id: " + id + " was sucesfully deleted from DB.");

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void truncateTable() throws SQLException {
        try {

            Statement statement = DBConnection.getConnection().createStatement();

            statement.executeUpdate(TRUNCATE);
            statement.close();

            System.out.println("Pacientes database was truncated.");

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getDetailsById(int id) throws SQLException {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1, id); // Set 1st WHERE to int

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                paciente.setNome(resultSet.getString("nome"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setDataNascimento(resultSet.getDate("dataNascimento").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                paciente.setSexo(resultSet.getString("sexo"));

            }

            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return paciente;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Paciente> findAll() throws SQLException {
        List<Paciente> pacientes = new LinkedList<Paciente>();

        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {

                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setDataNascimento(resultSet.getDate("dataNascimento").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                paciente.setSexo(resultSet.getString("sexo"));
                System.out.println(paciente.toString());
                pacientes.add(paciente);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return pacientes;
    }
    
     public Connection getConnection() {
 
        String dbURL = "jdbc:mysql://localhost:3306/docs";
        String dbUser = "root";
        String dbPassword = "NS@DQX1s";
 
        try {
            if (conn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
 
        return conn;
 
    }
 
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void create(Medico medico) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
