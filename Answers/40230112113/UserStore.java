import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserStore
{
    File file = new File("Users.txt");
    public void Save(User user)
    {
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter write = new FileWriter(file,true);
            write.write(user.getUsername()+",");
            write.write(user.getPassword()+",");
            write.write(user.getEmail()+"\n");
            write.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int Read(String username , String password)
    {
        int t=0;
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
                    PasswordUtils hash = new PasswordUtils();
                    if(s[1].equals(hash.SHA_256(password)))
                    {
                        t=2;
                        break block1;
                    }
                    else
                    {
                        t=1;
                        break block1;
                    }
                }
            }
            t=0;
            read.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return t;
    }
}
