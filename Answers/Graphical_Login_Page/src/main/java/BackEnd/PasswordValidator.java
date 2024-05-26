package BackEnd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    // this method return the complexity of password (0% to 100%) :
    public int getPasswordComplexity(String password) {
        Pattern p1 = Pattern.compile("[a-z]+");                // contains small words?        <20%>
        Matcher m1 = p1.matcher(password);
        Pattern p2 = Pattern.compile("[A-Z]+");                // contains capital words?      <20%>
        Matcher m2 = p2.matcher(password);
        Pattern p3 = Pattern.compile("[0-9]+");                // contains numbers?            <20%>
        Matcher m3 = p3.matcher(password);
        Pattern p4 = Pattern.compile("(@|-|_|.)");             // contains special characters? <20%>
        Matcher m4 = p4.matcher(password);
        Pattern p5 = Pattern.compile("[a-zA-z0-9@\\-_.]{8,}"); // length >= 8?                 <20%>
        Matcher m5 = p5.matcher(password);
        if (m5.find() && m4.find() && m3.find() && m2.find() && m1.find()) {
            return 100;
        } else if (m4.find() && m3.find() && m2.find() && m1.find()) {
            return 80;
        } else if (m3.find() && m2.find() && m1.find()) {
            return 60;
        } else if (m2.find() && m1.find()) {
            return 40;
        } else if (m1.find()) {
            return 20;
        } else {
            return 0;
        }
    }
}
