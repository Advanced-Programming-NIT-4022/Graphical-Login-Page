import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
    private String password;
    private String url;
    private String name;
    private String table;
    public Database(String _url, String _password, String _name, String _table){
        this.url = _url;
        this.password = _password;
        this.name = _name;
        this.table = _table;
    }

    public String insertToTable(ArrayList<String> list){
        int result;
        try {
            Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
            Statement statement = connection.createStatement();
            result = statement.executeUpdate("INSERT INTO "+this.table+" VALUES(\""+list.get(0)+"\",\""+list.get(1)+
                                            "\",\""+list.get(2)+"\")");
            if(result == 1)
                return "Insertion is successful";


        }catch (Exception e){
            return "Username exists.";
        }
        return "Error in Insertion";
    }

    public boolean searchInTable(String _column_, String _thing_){
        boolean flag = false;
        ArrayList<String> col = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.table);
            while (resultSet.next()){
                col.add(resultSet.getString(_column_));
            }

            if(col.contains(_thing_))
                flag = true;
            else{
                flag = false;
            }

        }catch (Exception e){
            System.out.println("Connection is interrupted. :-| ");
        }
        return flag;
    }

    public String findPassword(String email){
        try {
            Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
            Statement statement = connection.createStatement();
            ResultSet userSet = statement.executeQuery("SELECT * FROM user_repo");
            while (userSet.next()){
                if(userSet.getString("email").equals(email)){
                    return userSet.getString("password");
                }
            }
        }
        catch (Exception e){
            System.out.println("Connection is interrupted. :-|");
        }
        return "Not Found.";
    }

}
