import java.io.*;
import java.io.*;
import java.util.*;
public class UserStore {
        File objfile = new File("Users.txt");
        public void SaveInformation(User objuser)
        {
            try
            {
                if(!objfile.exists())
                {
                    objfile.createNewFile();
                }
                FileWriter objwrite = new FileWriter(objfile,true);
                objwrite.write(objuser.getUsername()+",");
                objwrite.write(objuser.getGmail()+",");
                objwrite.write(objuser.getPassword()+"\n");
                objwrite.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    public int Read(String username , String password)
    {
        int LoginOk=0;
        block1 : try
        {
            if(!objfile.exists())
            {
                objfile.createNewFile();
            }
            Scanner read = new Scanner(objfile);
            while(read.hasNextLine())
            {
                String[] s = read.nextLine().split(",");
                if (s[0].equals(username))
                {
                    HashPassword hash = new HashPassword();
                    if(s[2].equals(hash.SHA_256(password)))
                    {
                        LoginOk=2;
                        break block1;
                    }
                    else
                    {
                        LoginOk=1;
                        break block1;
                    }
                }
            }
            LoginOk=0;
            read.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return LoginOk;
    }
}
