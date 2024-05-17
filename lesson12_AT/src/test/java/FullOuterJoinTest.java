import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class FullOuterJoinTest {

    @Test
    void fullOuterTest() throws ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String path = "jdbc:jtds:sqlserver://93.84.82.170:1433;databaseName=Stormnet;";
        Connection connection = DriverManager.getConnection(path, "admin", "1234-qwer");
        Statement statement = connection.createStatement();

        try {
            String query = "SELECT *\n" +
                    " FROM [Stormnet].[dbo].[variant5task2first]\n" +
                    " FULL OUTER JOIN [Stormnet].[dbo].[variant5task2second]\n" +
                    " ON [Stormnet].[dbo].[variant5task2first].username = [Stormnet].[dbo].[variant5task2second].client\n" +
                    " WHERE [Stormnet].[dbo].[variant5task2first].username != 'tolik' ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Map<Object, Object> map = new HashMap<>();

                for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                    Object name = resultSet.getMetaData().getColumnName(i);
                    Object value = resultSet.getObject(i);
                    map.put(name, value);
                }

                String username = (String) map.get("username");

                Assertions.assertNotEquals(username, "tolik");
            }
            resultSet.close();
        } finally {
            statement.close();
            connection.close();
        }
    }
}