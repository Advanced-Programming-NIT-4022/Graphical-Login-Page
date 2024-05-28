import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
  private String username;
  private String hashPassword;
  private String email;
  public User(String username, String password, String email)
  {
    this.username = username;
    this.hashPassword = hashPassword(password);
    this.email = email;
  }
  public String getUsername() {
    return username;
  }
  public String getHashPassword() {
    return hashPassword;
  }
  public String getEmail() {
    return email;
  }
   public static String hashPassword(String password)
  {
  try
  {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(password.getBytes());
    StringBuilder str = new StringBuilder();
    for(byte b : hash)
    {
      str.append(String.format("%02x", b));
    }
    return str.toString();
  }
  catch(NoSuchAlgorithmException e)
  {
    throw new RuntimeException(e);
  }
}
}
