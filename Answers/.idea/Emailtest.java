import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailtest {
    static boolean Evalid(String em) {
        Pattern pe=Pattern.compile("\\.@gmail.com$");
        Matcher me= pe.matcher(em);
        boolean vem= me.find();
        return vem;
    }
}
