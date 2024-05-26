import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Storage {
    File file = new File("storage.txt");
    TemporaryStorage tem = new TemporaryStorage();
    public void writeFile(File file, String name, String email, String password) {
        try {
            FileWriter writer = new FileWriter(file,true);
            writer.write(name + "\n" + email + "\n" + password + "\n");
            writer.close();
        }catch (Exception e) {
            System.out.println("error : failed to write the file");
        }
    }
    public void readerFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String name = sc.nextLine();
                String email = sc.nextLine();
                String password = sc.nextLine();
                tem.name_email.put(name,email);
                tem.name_password.put(name,password);
            }
            reader.close();
        }catch (Exception e) {
            System.out.println("error : failed to read the file");
        }
    }
    public void fileEntry(String name, String email, String password) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (Exception e) {
            System.out.println("error : failed to create new file");
        }
        writeFile(file, name, email, password);
        tem.name_email.put(name,email);
        tem.name_password.put(name,password);
    }
}
