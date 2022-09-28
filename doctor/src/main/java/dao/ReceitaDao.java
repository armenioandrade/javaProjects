package dao;

import entity.Receita;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReceitaDao {

    Receita receita = new Receita();
    MedicoDao medicoDao;
    PacienteDao pacienteDao;
    private static final String INSERT = "INSERT INTO receita (descricao, id$medico, id$paciente, dataRegistro) VALUES (?,?,?,?)";
    private static final String FIND_BY_ID = "SELECT * FROM receita WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM receita ORDER BY idMedico";
    private static final String FIND_INNERJOIN = "SELECT receita.id as id, medico.nome as id$medico, paciente.nome as id$paciente, receita.descricao, receita.dataRegistro from receita inner join medico on medico.id = receita.id$medico inner join paciente on paciente.id = receita.id$paciente;";
    private static final String UPDATE = "UPDATE receita SET descricao=?, idMedico=?, idPaciente=?, dataRegistro=? WHERE id=?";
    private static final String DELETE = "DELETE FROM receita WHERE id=?";

    public void create(Receita receita) throws SQLException {

        try {

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(INSERT);
            ps.setString(1, receita.getDescricao());
            ps.setInt(2, receita.getMedico().getId());
            ps.setInt(3, receita.getPaciente().getId());
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.execute();

            System.out.println("Receita with following details was saved in DB: " + receita.toString());

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Receita> findAll() throws SQLException {
        ArrayList<Receita> receitas = new ArrayList<Receita>();

        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_INNERJOIN);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String medico = resultSet.getString("id$medico");
                String paciente = resultSet.getString("id$paciente");
                String descricao = resultSet.getString("descricao");
                Date dataRegistro = resultSet.getDate("dataRegistro");
                receitas.add(new Receita(id, medico, paciente, descricao, dataRegistro.toLocalDate()));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return receitas;
    }

    public Receita getDetailsById(Receita receita) throws SQLException {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1, receita.getId()); // Set 1st WHERE to int

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                receita.setId(resultSet.getInt("id"));
                receita.getMedico().setNome(resultSet.getString("id$medico"));
                receita.getPaciente().setNome(resultSet.getString("id$paciente"));
                receita.setDescricao(resultSet.getString("descricao"));
                receita.setDataRegistro(resultSet.getDate("dataRegistro").toLocalDate());
            }

            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("receita no dao: " + receita.toString());
        return receita;
    }

    public void delete(Receita receita){
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(DELETE);
            ps.setInt(1, receita.getId()); // Set 1st WHERE to int
            ps.execute();

        } catch (Exception e) {
        }
    }
    
    public MedicoDao getMedicoDao() {
        if (medicoDao == null) {
            medicoDao = new MedicoDao();
        }
        return medicoDao;
    }

    public void setMedicoDao(MedicoDao medicoDao) {
        this.medicoDao = medicoDao;
    }

    public PacienteDao getPacienteDao() {
        if (pacienteDao == null) {
            pacienteDao = new PacienteDao();
        }
        return pacienteDao;
    }

    public void setPacienteDao(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Receita getReceita() {
        if (receita == null) {
            receita = new Receita();
        }
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public ReceitaDao(Receita receita, MedicoDao medicoDao, PacienteDao pacienteDao) {
        this.receita = receita;
        this.medicoDao = medicoDao;
        this.pacienteDao = pacienteDao;
    }

    public ReceitaDao() {
    }

}
