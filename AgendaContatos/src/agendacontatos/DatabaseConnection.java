package agendacontatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=AgendaContatos;encrypt=true;trustServerCertificate=true;";
private static final String USER = "smar";  
private static final String PASSWORD = "smarapd";  

    public static Connection getConnection() throws SQLException {
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Falha ao conectar ao banco de dados", e);
        }
    }
}
