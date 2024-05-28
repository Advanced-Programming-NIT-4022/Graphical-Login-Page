package backend;

class User {

    private String password;
    String fullname,username,email;

    User(String password, String fullname, String username, String email){
        this.password = PasswordUtils.hashingPassword(password);
        this.fullname = fullname;
        this.username = username;
        this.email = email;
    }

    protected String getPassword() {
        return password;
    }
}
