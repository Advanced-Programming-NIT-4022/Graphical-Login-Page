package Answers;

import java.io.*;
import java.security.PublicKey;
import java.util.Objects;

public class Users
{
    public String registerUser(String username, String hashedPassword, String email)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true)))
        {
            if (Objects.equals(isUsernameTaken(username), "Yes"))
            {
                return "This username is taken!";
            }
            writer.write(username + "," + hashedPassword + "," + email + "\n");
            return "Registration successful";
        }
        catch (IOException e)
        {
            return "An error occurred.";
        }
    }

    public String isUsernameTaken(String username)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts[0].equals(username))
                {
                    return "Yes";
                }
            }
        }
        catch (IOException e)
        {
            return "An error occurred.";
        }
        return "No";
    }

    public String loginUser(String username , String hashedPassword)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (Objects.equals(parts[0], username) && Objects.equals(parts[1], hashedPassword))
                {
                    return "Login successful.";
                }
            }
        }
        catch (IOException e)
        {
            return "An error occurred.";
        }
        return "username or password is incorrect!";
    }
}
