
package dao;

import entity.Cliente;
import java.sql.SQLException;
import java.util.List;

    public interface Dao {
     
    public boolean authenticate(String eMail, String password) throws SQLException;
    public void create(Cliente cliente) throws SQLException;
    public void update(Cliente cliente) throws SQLException;
    public void delete(int id) throws SQLException;
    public void truncateTable() throws SQLException;
    public Cliente getDetailsById(int id) throws SQLException;
    public List<Cliente> findAll() throws SQLException;
     
}

