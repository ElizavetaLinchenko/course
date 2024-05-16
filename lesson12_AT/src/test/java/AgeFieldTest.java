import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgeFieldTest {
    @Test
    void testFieldValue() throws ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String path = "jdbc:jtds:sqlserver://93.84.82.170:1433;databaseName=Stormnet;";
        Connection connection = DriverManager.getConnection(path, "admin", "1234-qwer");
        Statement statement = connection.createStatement();

        try {
            String query = ("SELECT * FROM [Stormnet].[dbo].[variant5task3] WHERE age = 10");
            ResultSet resultSet = statement.executeQuery(query);
            List<Map<Object, Object>> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Map<Object, Object> map = new HashMap<>();
                for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                    System.out.println("Current column: " + resultSet.getMetaData().getColumnName(i));
                    System.out.println("Current column value: " + resultSet.getObject(i));
                    map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                }
                resultList.add(map);
            }
            Assertions.assertEquals(10, resultList.get(resultList.size() - 1).get("age"));
            resultSet.close();
        } finally {
            statement.close();
            connection.close();
        }
    }
}