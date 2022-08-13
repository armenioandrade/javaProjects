
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    
    public ConexaoDB(){
        
    }
    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/concessionaria","root","NS@DQX1s");
            return conn;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco nao localizado: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("erro ao conectar ao db");
        }
        return null;
    }
    
}
