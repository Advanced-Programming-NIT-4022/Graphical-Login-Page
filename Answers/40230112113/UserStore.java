import java.util.HashMap;

public class UserStore
{
    HashMap <String,String> user = new HashMap <String,String>();
    String email;

    UserStore(String email , HashMap <String,String> user)
    {
        this.email=email;
        this.user=user;
    }
}
