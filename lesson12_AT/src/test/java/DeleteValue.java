import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteValue {
    @Test
    void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String path = "jdbc:jtds:sqlserver://93.84.82.170:1433;databaseName=Stormnet;";
        Connection connection = DriverManager.getConnection(path, "admin", "1234-qwer");
        Statement statement = connection.createStatement();

        try {
            String query = "DELETE [Stormnet].[dbo].[variant5task1] WHERE username = 'Ivan'";
            statement.executeQuery(query);

        } finally {
            statement.close();
            connection.close();
        }
    }
}