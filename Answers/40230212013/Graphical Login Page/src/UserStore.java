import java.util.HashMap;
import java.util.Map;
import java.io.*;
public class UserStore {
  private static final String file = "users.txt";
  private static Map<String, User> users = new HashMap<>();
  public UserStore()
  {
    loadUsers();
  }
  public static boolean register(User user)
  {
    if(users.containsKey(user.getUsername()))
    {
      return false;
    }
    users.put(user.getUsername(), user);
    saveUsers();
    return true;
  }
  public static boolean login(String username, String password)
  {
    User user = users.get(username);
    if (user == null)
    {
      return false;
    }
    String hashPassword = User.hashPassword(password);
    return hashPassword.equals(user.getHashPassword());
  }
  private void loadUsers()
  {
    try(BufferedReader bufr = new BufferedReader(new FileReader(file)))
    {
      String line;
      while ((line = bufr.readLine()) != null) 
      {
        String[] parts = line.split(",");
        if(parts.length == 3)
        {
          User user = new User(parts[0], parts[1], parts[2]);
          users.put(user.getUsername(), user);
        }
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
  private static void saveUsers()
  {
  try(BufferedWriter bufw = new BufferedWriter(new FileWriter(file)))
  {
    for(User user : users.values())
    {
      bufw.write(user.getUsername() + "," + user.getHashPassword() + "," + user.getEmail());
      bufw.newLine();
    }
  }
  catch(IOException e)
  {
    e.printStackTrace();
  }
}
}
