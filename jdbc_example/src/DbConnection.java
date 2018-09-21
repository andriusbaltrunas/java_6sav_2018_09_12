import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/kcs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "MYSQL";

    public static Connection createConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}