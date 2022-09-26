package dao;

import entity.Medico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MedicoDao implements Dao {

    Connection conn = null;
    private static final String AUTHENTICATE = "SELECT * FROM medico WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM medico WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE medico";
    private static final String FIND_BY_ID = "SELECT * FROM medico WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM medico ORDER BY nome";
    private static final String INSERT = "INSERT INTO medico (nome, cpf, crm, sexo) VALUES (?,?,?,?)";
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

    public void update(Medico medico) throws SQLException {
        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(UPDATE);

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getCrm());
            ps.setString(4, medico.getSexo());
            ps.setInt(5, medico.getId());
            ps.executeUpdate();
            ps.close();

            System.out.println("Medico with id " + medico.getId() + " was updated in DB with following details: " + medico.toString());

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

    public Medico getDetailsById(Medico medico) throws SQLException {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1, medico.getId()); // Set 1st WHERE to int

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
     * @return @throws SQLException
     */
    public ArrayList<Medico> findAll() {
        ArrayList<Medico> medicos = new ArrayList<Medico>();

        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String crm = resultSet.getString("crm");
                String sexo = resultSet.getString("sexo");
                //System.out.println(medico.toString());    
                medicos.add(new Medico(id, nome, cpf, crm, sexo));
            }

            resultSet.close();
            statement.close();
            return medicos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
    public void update(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
