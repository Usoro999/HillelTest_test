package MySQLconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    private Connection connection;
    public Connection createConnection() {
        if(connection == null){
            try {
                connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root","root1234");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    }

    public static Statement createStatement() throws SQLException {

        Connect connect = new Connect();
        Connection connection = connect.createConnection();
        return connection.createStatement();
    }
}
