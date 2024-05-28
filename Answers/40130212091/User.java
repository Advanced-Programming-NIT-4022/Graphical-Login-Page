public class User {
    private String username;
    private String hashedpassword;
    private String email;

    public User(String username, String password, String email){
        this.username = username;
        this.hashedpassword = PasswordUtils.hashingPassword(password);
        this.email = email;
    }


    public String getusername(){
        return username;
    }

    public String getPassword(){
        return hashedpassword;
    }

    public String getEmail(){
        return email;
    }
}
