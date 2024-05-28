import java.io.File;
import java.io.FileWriter;

public class UserStore {
    File dataFile = new File("UsersData.txt");
    public void saveData (User user, PasswordUtils passwordUtils, EmailValidator email)
    {
        try{
            if(!dataFile.exists())
            {
                dataFile.createNewFile();
            }
            FileWriter writeD = new FileWriter(dataFile,true);
            writeD.write("Username: "+user.getUsernameIn()+", ");
            writeD.write("Password: "+ user.getPasswordIn()+", ");
            writeD.write("Email: "+user.getEmail()+"\n");
            writeD.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
