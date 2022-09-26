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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacienteDao implements Dao {

    Connection conn = null;
    private static final String AUTHENTICATE = "SELECT * FROM paciente WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM paciente WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE paciente";
    private static final String FIND_BY_ID = "SELECT * FROM paciente WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM paciente ORDER BY nome";
    private static final String INSERT = "INSERT INTO paciente (cpf,dataNascimento,sexo,nome) VALUES (?,?,?,?)";
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
            ps.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
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
    
    public void update(Paciente paciente) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE);

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setDate(3, java.sql.Date.valueOf(paciente.getDataNascimento()));    
            ps.setString(4, paciente.getSexo());
            ps.setInt(5, paciente.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Paciente with id " + paciente.getId() + " was updated in DB with following details: " + paciente.toString());

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
    
    public void delete(Paciente paciente) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(DELETE);

            ps.setInt(1, paciente.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Paciente with id: " + paciente.getId() + " was sucesfully deleted from DB.");

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

   
    public Paciente getDetailsById(Paciente paciente) throws SQLException {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1, paciente.getId()); // Set 1st WHERE to int

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                paciente.setNome(resultSet.getString("nome"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
                paciente.setSexo(resultSet.getString("sexo"));

            }

            resultSet.close();
            ps.close();
            
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("paciente no dao: "+paciente.toString());
        return paciente;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Paciente> findAll() throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date data = resultSet.getDate("dataNascimento");
                String sexo = resultSet.getString("sexo");
                pacientes.add(new Paciente(id, sexo, cpf, nome, data.toLocalDate()));
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

    @Override
    public Medico getDetailsById(Medico medico) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
