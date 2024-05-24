public class User
{
    private String email;
    private String username;
    private String password;    
    PasswordUtils hash = new PasswordUtils();

    User(String email , String username , String password)
    {
        setEmail(email);
        setUsername(username);
        this.password = hash.SHA_256(password);
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getPassword()
    {
        return password;
    }
}
