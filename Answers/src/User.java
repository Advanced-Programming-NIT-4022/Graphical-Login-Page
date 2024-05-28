import java.sql.SQLException;

public class User {
    private String Username;
    private String Email;
    private String Password;
    public User(String username,String email,String password){
        Username=username;
        Email=email;
        Password=password;
    }
    public void adduser(String username,String password,String email) throws SQLException {
        Db db=new Db();
        db.statement.executeUpdate("INSERT INTO loginpage (Name,Email,Password) VALUES ('"+username+"','"+email+"','"+password+"')");
    }
}
