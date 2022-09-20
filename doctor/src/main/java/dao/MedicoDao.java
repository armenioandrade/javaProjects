package dao;

import entity.Medico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MedicoDao implements Dao {

    Connection conn = null;
    private static final String AUTHENTICATE = "SELECT * FROM medico WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM medico WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE medico";
    private static final String FIND_BY_ID = "SELECT * FROM medico WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM medico ORDER BY id";
    private static final String INSERT = "INSERT INTO Medico (nome, cpf, crm, sexo) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE medico SET nome=?, cpf=?, crm=?, sexo=? WHERE id=?";
    Medico medico = new Medico();

    @Override
    public boolean authenticate(String eMail, String password) throws SQLException {
        
        return false;
    }
    
    @Override
    public void create(Medico medico) throws SQLException {

        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(INSERT);

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getCrm());
            ps.setString(4, medico.getSexo());
            ps.executeUpdate();
            ps.close();

            System.out.println("Medico with following details was saved in DB: " + medico.toString());

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE);

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getCrm());
            ps.setString(4, medico.getSexo());
            ps.executeUpdate();
            ps.close();

            System.out.println("Medico with id " + medico.getId() + " was updated in DB with following details: " + obj.toString());

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

            System.out.println("Medico with id: " + id + " was sucesfully deleted from DB.");

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

            System.out.println("Medicos database was truncated.");

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
                medico.setNome(resultSet.getString("nome"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setSexo(resultSet.getString("sexo"));

            }

            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return medico;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Object> findAll() throws SQLException {
        List<Object> medicos = new LinkedList<Object>();

        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {

                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setSexo(resultSet.getString("sexo"));
                System.out.println(medico.toString());
                medicos.add(medico);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return medicos;
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


}