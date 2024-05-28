import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage");
    Statement statement=connection.createStatement();
    public Db() throws SQLException {
    }

}
