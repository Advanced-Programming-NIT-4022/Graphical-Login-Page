import java.util.regex.Pattern;
public class GmailValid {
    public int gmailvalid(String Gmail){
        int valid =0 ;
      if(Pattern.matches("(\\w(.)?\\w){1,}@[ge]mail.com", Gmail)){
          valid=1;
        }
        return valid;
    }
}
