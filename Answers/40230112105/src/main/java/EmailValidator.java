import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class EmailValidator {
    static boolean validation(String email){
        if(Pattern.matches("^[^0-9][a-zA-Z0-9!#$%^&*.]{4,}[^.$]@[^.](?=.*[a-zA-Z]{1,})[a-zA-Z0-9.]*$",email)){
            return true;
        } else{
            return false;
        }
    }

    static boolean found(String Email) {
        ResultSet rs = Connect.getConnectExecute("SELECT email FROM account WHERE email = '"+Email+"'");
        try {
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean usernamefound(String username) {
        ResultSet rs = Connect.getConnectExecute("SELECT username FROM account WHERE username = '"+username+"'");
        try {
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
