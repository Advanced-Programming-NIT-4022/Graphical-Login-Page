import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserStore {
    File dataFile = new File("UsersData.txt");
    public void saveData (User user)
    {
        try{
            if(!dataFile.exists())
            {
                dataFile.createNewFile();
            }
            FileWriter writeD = new FileWriter(dataFile,true);
            writeD.write(user.getUsernameIn()+", ");
            writeD.write(user.getPasswordIn()+", ");
            writeD.write(user.getEmail()+"\n");
            writeD.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
public int read(String username, String password)
{
    int i = 0;
    block1: try
    {
        if(!dataFile.exists())
        {
            dataFile.createNewFile();
        }
        Scanner scanner = new Scanner(dataFile);
        while (scanner.hasNextLine())
        {
            String[] dataArray = scanner.nextLine().split(", ");
            if(dataArray[0].equals(username))
            {
                PasswordUtils hash = new PasswordUtils();
                if(dataArray[1].equals(hash.SHA_256(password)))
                {
                    i =2;
                    break block1;
                }
                else{
                    i=1;
                    break block1;
                }
            }
        }
        i = 0;
        scanner.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return i;
}


}
