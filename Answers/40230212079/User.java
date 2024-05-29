public class User {
    private String Gmail;
    private String Username;
    private String Password;
    HashPassword objhashpassword = new HashPassword();

    User(String Username , String Gmail , String Password)
    {
        setGmail(Gmail);
        setUsername(Username);
        setPassword(Password);
    }
    public String getUsername()
    {
        return Username;
    }
    public void setUsername(String username)
    {
        this.Username=username;
    }
    public String getGmail()
    {
        return Gmail;
    }
    public void setGmail(String email)
    {
        this.Gmail=email;
    }
    public String getPassword()
    {
        return Password;
    }
    public String setPassword(String Password){
        return this.Password = objhashpassword.SHA_256(Password);
    }
}
