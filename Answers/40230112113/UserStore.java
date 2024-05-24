import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserStore
{
    File file = new File("Users.txt");
    public void Save(String username , String password, String email)
    {
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter write = new FileWriter(file);
            write.write(username);
            write.write(password);
            write.write(email+"\n");
            write.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Boolean Read(String username)
    {
        boolean t=false;
        block1 : try 
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            Scanner read = new Scanner(file);
            while(read.hasNextLine())
            {
                String[] s = read.nextLine().split(",");
                if (s[0].equals(username))
                {
                    t=true;
                    break block1;
                }
            }
            read.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return t;
    }
}
