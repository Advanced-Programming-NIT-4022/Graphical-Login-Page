import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

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

    public void insertToTable(ArrayList<String> list){
        int result;
        try {
            Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
            Statement statement = connection.createStatement();
            result = statement.executeUpdate("INSERT INTO "+this.table+" VALUES(\""+list.get(0)+"\",\""+list.get(1)+
                                            "\",\""+list.get(2)+"\")");
            if(result == 1)
                System.out.println("Insertion is successful");
            else{
                System.out.println("One error comes up");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
