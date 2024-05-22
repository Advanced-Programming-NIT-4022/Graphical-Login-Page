import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    //Represents a user and contains methods for hashing and validating passwords
    private String UserName;
    private String Email;
    private String Password;

    public User(String UserName , String Email , String Password) {
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
    }

    private String Hash_SHA_256(String Password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /*
            This MessageDigest class provides applications the functionality of a message digest algorithm,
             such as SHA-1 or SHA-256.
              Message digests are secure one-way hash functions
              that take arbitrary-sized data and output a fixed-length hash value.
              Basically it's a Hash Function for SHA-1 to SHA-256
             */
            byte[] hashBytes = digest.digest(Password.getBytes());
            //A digest is a short fixed-length value derived from some variable-length input
            //A salt is a piece of random data added to a password before it is hashed and stored
            StringBuilder builder = new StringBuilder();
            for (byte b : hashBytes) {
                builder.append(String.format("%02x", b));
                //%02x means if your provided value is less than two digits then 0 will be prepended
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }



    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public static void main(String[] args) {
        User user = new User("Sadra" , "sdjflsj" , "@Sadraahmadi83");
        user.Hash_SHA_256(user.getPassword());
    }

}

