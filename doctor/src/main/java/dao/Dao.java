
package dao;

import entity.Medico;
import java.sql.SQLException;
import java.util.List;


public interface Dao {
    public boolean authenticate(String eMail, String password) throws SQLException;
    public void create(Medico medico) throws SQLException;
    public void update(Object obj) throws SQLException;
    public void delete(int id) throws SQLException;
    public void truncateTable() throws SQLException;
    public Object getDetailsById(int id) throws SQLException;
}
