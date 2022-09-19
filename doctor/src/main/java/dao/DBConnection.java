package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

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

    public static void closeConnection() {
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
