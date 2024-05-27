public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getusername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
