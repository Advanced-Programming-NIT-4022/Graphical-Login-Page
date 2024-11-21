import java.io.*;
import java.util.Scanner;

public class User {
    File fu=new File("users.txt");
    public void regist(String u,String hp,String em) {
        try {
            if (fu.exists()) {
                BufferedWriter w=new BufferedWriter(new FileWriter(fu,true));
                w.append(u+","+hp+","+em);
                w.newLine();
                w.close();
            } else {
                System.out.println("file not found!");
            }
        } catch (IOException e) {
            System.out.println("in the writing process sth went wrong!");
            e.printStackTrace();
        }
    }
    public boolean checktheinfo(String uc,String hpc,String emc) {
        try {
            Scanner fr=new Scanner(fu);
            while (fr.hasNextLine()) {
                String line=fr.nextLine();
                if (line.equals(uc+","+hpc+","+emc)) {
                    fr.close();
                    return true;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("in the reading process sth went wrong!");
            e.printStackTrace();
        }
        return false;
    }
}
